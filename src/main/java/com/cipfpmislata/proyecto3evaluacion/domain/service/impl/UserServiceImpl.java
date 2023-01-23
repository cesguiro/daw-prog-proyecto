package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cipfpmislata.proyecto3evaluacion.UUID.impl.UserUUIDRandomGenerator;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.User;
import com.cipfpmislata.proyecto3evaluacion.domain.service.UserService;
import com.cipfpmislata.proyecto3evaluacion.exception.SigninException;
import com.cipfpmislata.proyecto3evaluacion.exception.SignupException;
import com.cipfpmislata.proyecto3evaluacion.persistence.UserRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.UserRepositoryImplJDBC;
import com.cipfpmislata.proyecto3evaluacion.security.UserSession;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository = new UserRepositoryImplJDBC();

    private String mailRegex = "^(.+)@(.+)$";
    //Pattern pattern = Pattern.compile(mailRegex);

    @Override
    public boolean create(String name, String mail, String password, String repeat_password) throws SignupException {
        //Passwords no coinciden
        if(!password.equals(repeat_password)) {
            throw new SignupException("Las contraseñas no coinciden");
        }

        //Mail con formato incorrecto
        if(!Pattern.matches(mailRegex, mail)){
            throw new SignupException("Formato de email inválido");
        }

        //Mail repetido
        if (userRepeated(mail)) {
            throw new SignupException("El email ya está registrado");
        }

        UserUUIDRandomGenerator userUUIDRandomGenerator = new UserUUIDRandomGenerator();
        String id = userUUIDRandomGenerator.generate();

        User user = new User(id, name, mail, encryptPassword(password));
        return userRepository.create(user);                
    }

    private boolean userRepeated(String mail) {
        User user = userRepository.findByMail(mail);
        return user != null? true: false;                
    }

    private String encryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public void login(String mail, String password) throws SigninException {
        User user =  userRepository.findByMail(mail);
        if(user != null && BCrypt.checkpw(password, encryptPassword(password))){
            System.out.println("Credenciales correctas");
            UserSession.setUserId(user.getId());
        } else {
            throw new SigninException("Nombre de usuario o contraseña incorrectos");
        }
    }

    
}

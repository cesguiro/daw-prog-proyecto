package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.User;
import com.cipfpmislata.proyecto3evaluacion.domain.service.UserService;
import com.cipfpmislata.proyecto3evaluacion.persistence.UserRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.UserRepositoryImplJDBC;
import com.cipfpmislata.proyecto3evaluacion.security.UserSession;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository = new UserRepositoryImplJDBC();

    private String mailRegex = "^(.+)@(.+)$";
    //Pattern pattern = Pattern.compile(mailRegex);

    @Override
    public boolean create(String name, String mail, String password, String repeat_password) {
        if(!password.equals(repeat_password)) {
            throw new RuntimeException("Los passwords no coinciden");
        }

        if(!Pattern.matches(mailRegex, mail)){
            throw new RuntimeException("Formato de mail incorrecto");
        }

        try {
            User user = new User(name, mail, encryptPassword(password));
            return userRepository.create(user);                
        } catch(Exception e) {
            throw e;
        }

    }

    private String encryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public boolean login(String mail, String password) {
        try {
            User user =  userRepository.findByMail(mail);
            if(user != null && BCrypt.checkpw(password, encryptPassword(password))){
                System.out.println("Credenciales correctas");
                UserSession.setAttribute("user_id", user.getId());
                return true;
            } else {
                System.out.println("Fallo en las credenciales");
                return false;
            }
        } catch(Exception e) {
            throw e;
        }        
    }

    
}

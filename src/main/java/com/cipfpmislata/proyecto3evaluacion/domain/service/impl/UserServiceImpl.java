package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.User;
import com.cipfpmislata.proyecto3evaluacion.domain.service.UserService;
import com.cipfpmislata.proyecto3evaluacion.persistence.UserRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.UserRepositoryImplJDBC;

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

    
}

package com.cipfpmislata.proyecto3evaluacion.domain.service;

import com.cipfpmislata.proyecto3evaluacion.exception.SigninException;
import com.cipfpmislata.proyecto3evaluacion.exception.SignupException;

public interface UserService {
    
    public boolean create(String name, String mail, String password, String repeat_password) throws SignupException;

    public void login(String mail, String password) throws SigninException;
}

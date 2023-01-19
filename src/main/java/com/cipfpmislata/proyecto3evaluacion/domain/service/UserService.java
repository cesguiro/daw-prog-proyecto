package com.cipfpmislata.proyecto3evaluacion.domain.service;

public interface UserService {
    
    public boolean create(String name, String mail, String password, String repeat_password);

    public boolean login(String mail, String password);
}

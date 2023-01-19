package com.cipfpmislata.proyecto3evaluacion.persistence;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.User;

public interface UserRepository {
    
    public boolean create(User user);

    public User findByMail(String mail);
}

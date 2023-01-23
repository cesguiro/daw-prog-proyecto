package com.cipfpmislata.proyecto3evaluacion.UUID.impl;

import java.util.UUID;

import com.cipfpmislata.proyecto3evaluacion.UUID.UUIDGenerator;

public class UserUUIDRandomGenerator implements UUIDGenerator{

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
    
}

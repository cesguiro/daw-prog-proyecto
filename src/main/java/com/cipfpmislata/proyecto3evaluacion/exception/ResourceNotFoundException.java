package com.cipfpmislata.proyecto3evaluacion.exception;

public class ResourceNotFoundException extends Exception{

    private String message;

    public ResourceNotFoundException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

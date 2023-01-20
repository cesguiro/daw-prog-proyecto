package com.cipfpmislata.proyecto3evaluacion.exception;

public class SignupException extends Exception {

    private String message;

    public SignupException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}

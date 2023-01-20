package com.cipfpmislata.proyecto3evaluacion.exception;

public class SigninException extends Exception{
    
    private String message;

    public SigninException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

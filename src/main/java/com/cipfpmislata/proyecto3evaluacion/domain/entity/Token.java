package com.cipfpmislata.proyecto3evaluacion.domain.entity;

public class Token {
    
    private String value;
    private static Token instance;

    private Token(){

    }

    public static Token getInstance(){
        if(instance == null) {
            instance = new Token();
        }
        return instance;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

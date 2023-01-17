package com.cipfpmislata.proyecto3evaluacion.util;

import jakarta.servlet.http.HttpSession;

public class DataSession {
    
    HttpSession httpSession;

    public DataSession(HttpSession httpSession){
        this.httpSession = httpSession;
    }

    public Object getAttribute(String attribute) {
        return httpSession.getAttribute(attribute);
    }

    public void setAttribute(String attribute, Object value) {
        httpSession.setAttribute(attribute, value);
    }
}

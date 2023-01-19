package com.cipfpmislata.proyecto3evaluacion.security;

import jakarta.servlet.http.HttpSession;

public class UserSession {
    
    private static HttpSession session;

    public static void setSession(HttpSession session){
        UserSession.session = session;
    }

    public static HttpSession getSession(){
        return session;
    }

    public static void setAttribute(String name, Object value){
        session.setAttribute(name, value);
    }

    public static Object getAttribute(String name){
        return session.getAttribute(name);
    }
        
    public static void clear(){
        //session.invalidate();
        session.removeAttribute("user_id");
    }
}

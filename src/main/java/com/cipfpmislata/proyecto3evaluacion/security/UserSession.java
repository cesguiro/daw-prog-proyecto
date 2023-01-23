package com.cipfpmislata.proyecto3evaluacion.security;

import jakarta.servlet.http.HttpSession;

public class UserSession {
    
    private static HttpSession session;
    private final static String USER_ID = "user_id";

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
        
    public static void removeAttribute(String name){
        session.removeAttribute(name);
    }


    public static void setUserId(String id){
        setAttribute(USER_ID, id);
    }

    public static String getUserId(){
        return (String) getAttribute(USER_ID);
    }

    public static boolean isLogged(){
        return (getUserId() != null)? true: false;
    }

    public static void clear(){
        session.invalidate();
    }

}

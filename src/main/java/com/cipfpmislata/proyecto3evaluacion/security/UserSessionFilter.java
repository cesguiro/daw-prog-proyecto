package com.cipfpmislata.proyecto3evaluacion.security;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.cipfpmislata.proyecto3evaluacion.util.DataSession;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class UserSessionFilter implements Filter{

    public DataSession dataSession;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        //System.out.println("Se activa el filtro");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        UserSession.setSession(httpServletRequest.getSession());

        chain.doFilter(request, response);
    }
    
}

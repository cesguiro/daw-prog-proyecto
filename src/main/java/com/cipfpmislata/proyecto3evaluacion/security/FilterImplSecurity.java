package com.cipfpmislata.proyecto3evaluacion.security;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cipfpmislata.proyecto3evaluacion.util.DataSession;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/*@Component
@Order(1)*/
public class FilterImplSecurity implements Filter{

    public DataSession dataSession;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        /*HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpSession httpSession = httpServletRequest.getSession(false);

        System.out.println("Filtro activo");

        if(httpSession == null) {
            System.out.println("usuario no logueado");
        } else {
            System.out.println("usuario logueado");
        }*/
        //chain.doFilter(request, response);
        
    }
    
}
/*package com.cipfpmislata.proyecto3evaluacion.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthenticationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {            
    
            HttpSession httpSession = request.getSession(false);
    
            System.out.println("Filtro autentificación activo");
    
            if(httpSession == null) {
                System.out.println("usuario no logueado");
            } else {
                System.out.println("usuario logueado");
            }
            filterChain.doFilter(request, response);           
    }
    
}*/

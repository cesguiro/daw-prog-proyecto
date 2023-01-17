package com.cipfpmislata.proyecto3evaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cipfpmislata.proyecto3evaluacion.domain.service.UserService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    
    private UserService userService = new UserServiceImpl();
    
    @GetMapping("/registro")
    public String showSignupForm(){
        return "signup";
    }

    @PostMapping("/registro")
    public String signup(HttpServletRequest httpServletRequest) {
        System.out.println("Se inicia el proceso de registro");
        String name = httpServletRequest.getParameter("name");
        String mail = httpServletRequest.getParameter("mail");
        String password = httpServletRequest.getParameter("password");
        String repeat_password = httpServletRequest.getParameter("repeat_password");
        System.out.println("Nombre: " + name + ", mail: " + mail + ", password: " + password + ", repeat_password: " + repeat_password);
        try {
            userService.create(name, mail, password, repeat_password);
        } catch (Exception e) {
            System.out.println("Fallo en el sistema de registro");
        }
        System.out.println("Terminado el proceso de registro");
        return "index";
    }

    @GetMapping("/login")
    public String showSigninForm(){
        return "signin";
    }

    @PostMapping("/login")
    public String signin(HttpServletRequest httpServletRequest){
        System.out.println("Se inicia el proceso de login");
        String mail = httpServletRequest.getParameter("mail");
        String password = httpServletRequest.getParameter("password");
        System.out.println("Mail: " + mail + ", password: " + password);
        return "index";
    }
}

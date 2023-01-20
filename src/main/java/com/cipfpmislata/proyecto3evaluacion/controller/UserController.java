package com.cipfpmislata.proyecto3evaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cipfpmislata.proyecto3evaluacion.domain.service.UserService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.UserServiceImpl;
import com.cipfpmislata.proyecto3evaluacion.exception.SigninException;
import com.cipfpmislata.proyecto3evaluacion.exception.SignupException;
import com.cipfpmislata.proyecto3evaluacion.security.UserSession;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    
    private UserService userService = new UserServiceImpl();
    
    @GetMapping("/registro")
    public String showSignupForm(){
        //Si ya está logueado redirigir al index
        if(UserSession.isLogged()){
            return "redirect:/";
        }
        return "signup";
    }

    @PostMapping("/registro")
    public String signup(HttpServletRequest httpServletRequest, Model model) {
        //Si ya está logueado redirigir al index
        if(UserSession.isLogged()){
            return "redirect:/";
        }
        String name = httpServletRequest.getParameter("name");
        String mail = httpServletRequest.getParameter("mail");
        String password = httpServletRequest.getParameter("password");
        String repeat_password = httpServletRequest.getParameter("repeat_password");
        try {
            userService.create(name, mail, password, repeat_password);
        } catch (SignupException e){
            model.addAttribute("error", e.getMessage());
            return "signup";
        } catch (Exception e) {
            model.addAttribute("error", "Ups, algo ha ido mal. Vuelve a intentarlo más tarde");
            return "signup";
        }
        System.out.println("Terminado el proceso de registro");
        return "index";
    }

    @GetMapping("/login")
    public String showSigninForm(){
        //Si ya está logueado redirigir al index
        if(UserSession.isLogged()){
            return "redirect:/";
        }
        return "signin";
    }

    @PostMapping("/login")
    public String signin(HttpServletRequest httpServletRequest, Model model){
        //Si ya está logueado redirigir al index
        if(UserSession.isLogged()){
            return "redirect:/";
        }

        String mail = httpServletRequest.getParameter("mail");
        String password = httpServletRequest.getParameter("password");
        try {
            userService.login(mail, password);
        } catch (SigninException e) {
            model.addAttribute("error", e.getMessage());
            return "signin";
        } catch (Exception e) {
            model.addAttribute("error", "Ups, algo ha ido mal. Vuelve a intentarlo más tarde");
            return "signin";
        }
        return "index";
    }

    @GetMapping("/logout")
    public String signout(){
        //Si no está logueado redirigir al index
        if(!UserSession.isLogged()){
            return "redirect:/";
        }

        UserSession.clear();
        return "index";
    }
}

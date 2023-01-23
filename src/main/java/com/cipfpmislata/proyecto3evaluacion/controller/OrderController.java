package com.cipfpmislata.proyecto3evaluacion.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;
import com.cipfpmislata.proyecto3evaluacion.domain.service.CartService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.OrderService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.CartServiceImpl;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.OrderServiceImpl;
import com.cipfpmislata.proyecto3evaluacion.security.UserSession;

@Controller
public class OrderController {
    
    private OrderService orderService = new OrderServiceImpl();
    private CartService cartService = new CartServiceImpl();

    @PostMapping("/orders")
    public String create(){
        if (!UserSession.isLogged()) {
            return "redirect:/login";
        }
        String user_id = UserSession.getUserId();
        Cart cart = cartService.getByUserId(user_id);
        orderService.create(cart);
        return null;
    }

}

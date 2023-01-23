package com.cipfpmislata.proyecto3evaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Article;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.domain.service.CartService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.ProductService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.CartServiceImpl;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.ProductServiceImpl;
import com.cipfpmislata.proyecto3evaluacion.security.UserSession;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    private CartService cartService = new CartServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    
    @PostMapping("/carritos/activo")
    public String addArticle(HttpServletRequest httpServletRequest){
        if (!UserSession.isLogged()) {
            return "redirect:/login";
        }
        int product_id = Integer.parseInt(httpServletRequest.getParameter("id"));
        int quantity = Integer.parseInt(httpServletRequest.getParameter("quantity"));
        Product product = productService.read(product_id);
        String user_id = UserSession.getUserId();
        System.out.println("USUARIO:" + user_id);
        Article article = new Article(user_id, product_id, quantity, product.getPrice(), product.getBrand() + " - " + product.getName());
        System.out.println(article);
        cartService.addArticle(article);
        return "index";
    }

    @GetMapping("/carritos/activo")
    public String show(Model model){
        if (!UserSession.isLogged()) {
            return "redirect:/login";
        }
        String user_id = UserSession.getUserId();
        Cart cart = cartService.getByUserId(user_id);
        model.addAttribute(cart);
        return "cart";
    }

    @DeleteMapping("/carritos/activo/articulos/{article_id}")
    public String deleteArticle(@PathVariable int article_id, Model model){
        if (!UserSession.isLogged()) {
            return "redirect:/login";
        }
        String user_id = UserSession.getUserId();
        boolean result = cartService.deleteArticle(article_id, user_id);
        return "redirect:/carritos/activo";
    }
}

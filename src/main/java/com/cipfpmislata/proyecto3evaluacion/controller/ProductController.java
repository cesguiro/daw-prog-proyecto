package com.cipfpmislata.proyecto3evaluacion.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.domain.service.ProductService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.ProductServiceImpl;

@Controller
public class ProductController {
    
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/categorias/{id}")
    //public String getByCategoryId(@PathVariable("id") int id, Model model) {
    public String getByCategoryId(@PathVariable int id, Model model) {
        
        List<Product> products = productService.getByCategoryId(id);
        System.out.println(products);
        model.addAttribute("products", products);

        return "products";
    }

}

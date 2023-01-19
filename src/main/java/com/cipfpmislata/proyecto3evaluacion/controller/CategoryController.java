package com.cipfpmislata.proyecto3evaluacion.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Category;
import com.cipfpmislata.proyecto3evaluacion.domain.service.CategoryService;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.CategoryServiceImpl;

@Controller
public class CategoryController {

    private CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("/categorias")
    public String getAll(Model model){
        try {
            List<Category> categories = categoryService.getAll();            
            model.addAttribute("categories", categories);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "categories";
    }
    
}

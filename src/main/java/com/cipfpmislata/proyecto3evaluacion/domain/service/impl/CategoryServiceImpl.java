package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Category;
import com.cipfpmislata.proyecto3evaluacion.domain.service.CategoryService;
import com.cipfpmislata.proyecto3evaluacion.persistence.CategoryRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.CategoryRepositoryImplJDBC;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository = new CategoryRepositoryImplJDBC();
    
    @Override
    public List<Category> getAll() {
        try {
            List<Category> categories = categoryRepository.getAll();            
            System.out.println("Todo correcto");
            return categories;
        } catch (Exception e) {
            throw e;
        }
    }
    
}

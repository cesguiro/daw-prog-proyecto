package com.cipfpmislata.proyecto3evaluacion.domain.service;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;

public interface ProductService {
    
    public List<Product> getByCategoryId(int category_id);
    public Product read(int id);

}

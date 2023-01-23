package com.cipfpmislata.proyecto3evaluacion.persistence;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;

public interface ProductRepository{

    public List<Product> getByCategoryId(int category_id);

    public Product read(int id);
    
}

package com.cipfpmislata.proyecto3evaluacion.persistence;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;

public interface ProductRepository extends GenericRepository<Product, Integer>{

    public List<Product> getByCategoryId(int id);
    
}

package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.domain.service.ProductService;
import com.cipfpmislata.proyecto3evaluacion.persistence.ProductRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.ProductRepositoryImplJDBC;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository = new ProductRepositoryImplJDBC();

    @Override
    public List<Product> getByCategoryId(int id) {
        try {
            List<Product> products = productRepository.getByCategoryId(id);
            return products;
        } catch (Exception e) {
            throw e;
        }
    }
    
}

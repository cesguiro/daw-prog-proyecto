package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.domain.service.ProductService;
import com.cipfpmislata.proyecto3evaluacion.exception.ResourceNotFoundException;
import com.cipfpmislata.proyecto3evaluacion.persistence.ProductRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.ProductRepositoryImplJDBC;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository = new ProductRepositoryImplJDBC();

    @Override
    public List<Product> getByCategoryId(int category_id) {
        try {
            List<Product> products = productRepository.getByCategoryId(category_id);
            return products;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Product read(int id) throws ResourceNotFoundException {
        return productRepository.read(id);
    }
    
}

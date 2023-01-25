package com.cipfpmislata.proyecto3evaluacion.persistence;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Category;
//import com.cipfpmislata.proyecto3evaluacion.exception.ResourceNotFoundException;

public interface CategoryRepository{
    //public Category read(int id) throws ResourceNotFoundException;
    public List<Category> getAll();
}

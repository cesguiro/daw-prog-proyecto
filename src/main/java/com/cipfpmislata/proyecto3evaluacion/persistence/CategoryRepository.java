package com.cipfpmislata.proyecto3evaluacion.persistence;

import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Category;

public interface CategoryRepository{
    public Category read(int id);
    public List<Category> getAll();
}

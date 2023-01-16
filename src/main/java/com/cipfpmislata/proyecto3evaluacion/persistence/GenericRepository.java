package com.cipfpmislata.proyecto3evaluacion.persistence;

import java.util.List;

public interface GenericRepository<EntityType, PrimaryKeyType> {
    
    public boolean create(EntityType entity);
    public EntityType read(PrimaryKeyType primaryKey);
    public boolean update(EntityType entity);
    public boolean delete(EntityType entity);

    public List<EntityType> getAll();
}

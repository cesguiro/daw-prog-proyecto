package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cipfpmislata.proyecto3evaluacion.database.DBUtil;
import com.cipfpmislata.proyecto3evaluacion.database.TableNames;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Category;
import com.cipfpmislata.proyecto3evaluacion.persistence.CategoryRepository;

@Repository
public class CategoryRepositoryImplJDBC implements CategoryRepository{
    
    private TableNames tableName = TableNames.CATEGORIES;

    /*@Override
    public Category read(int id) throws ResourceNotFoundException {
        try {
            Connection connection = DBUtil.open();
            String sql = "SELECT * FROM " + tableName.name().toLowerCase() + " WHERE id = ? LIMIT 1";
            List<Object> params = List.of(id);
            ResultSet resultSet = DBUtil.select(connection, sql, params);
            if (resultSet.next()) {
                Category category = new Category(
                    resultSet.getInt("id"), 
                    resultSet.getString("name"),
                    resultSet.getString("image")
                );
                return  category;                    
            } else {
                throw new ResourceNotFoundException("Categoría no encontrada");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }*/

    @Override
    public List<Category> getAll() {
        try {
            List<Category> categories = new ArrayList<>();
            Connection connection = DBUtil.open();
            String sql = "SELECT * FROM " + tableName.name().toLowerCase();
            ResultSet resultSet = DBUtil.select(connection, sql, null);
            while (resultSet.next()) {
                Category category = new Category(
                    resultSet.getInt("id"), 
                    resultSet.getString("name"),
                    resultSet.getString("image")
                );
                categories.add(category);
            }
            DBUtil.close(connection);
            return  categories;                    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.database.DBUtil;
import com.cipfpmislata.proyecto3evaluacion.database.TableNames;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.persistence.ProductRepository;

public class ProductRepositoryImplJDBC implements ProductRepository{

    private TableNames tableName = TableNames.PRODUCTS;

    @Override
    public boolean create(Product entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Product read(Integer primaryKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Product entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Product entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Product> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getByCategoryId(int id) {
        try {
            List<Product> products = new ArrayList<>();
            Connection connection = DBUtil.open();
            String sql = "SELECT * FROM " + tableName.name().toLowerCase() + " WHERE category_id = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = DBUtil.select(connection, sql, params);
            while (resultSet.next()) {
                Product product = new Product(
                    resultSet.getInt("id"), 
                    resultSet.getString("brand"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("id")

                );
                products.add(product);
            }
            DBUtil.close(connection);
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
}

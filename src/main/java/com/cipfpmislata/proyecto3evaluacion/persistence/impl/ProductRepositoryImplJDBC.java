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
    public Product read(int id) {
        Connection connection = DBUtil.open();
        String sql = "SELECT * FROM " + tableName.name().toLowerCase() + " WHERE id = ?";
        List<Object> params = List.of(id);
        ResultSet resultSet = DBUtil.select(connection, sql, params);
        DBUtil.close(connection);
        try {
            if (resultSet.next()) {
                Product product = new Product(
                    resultSet.getInt("id"), 
                    resultSet.getString("brand"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getInt("id")
    
                );
                return product;
            } else {
                throw new RuntimeException();
            }
                
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}

    @Override
    public List<Product> getByCategoryId(int category_id) {
        try {
            List<Product> products = new ArrayList<>();
            Connection connection = DBUtil.open();
            String sql = "SELECT * FROM " + tableName.name().toLowerCase() + " WHERE category_id = ?";
            List<Object> params = List.of(category_id);
            ResultSet resultSet = DBUtil.select(connection, sql, params);
            while (resultSet.next()) {
                Product product = new Product(
                    resultSet.getInt("id"), 
                    resultSet.getString("brand"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getBigDecimal("price"),
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

package com.cipfpmislata.proyecto3evaluacion.persistence.mapper;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String name = rs.getString("name");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        int category_id = rs.getInt("category_id");
        return new Product(id, brand, name, description, price, category_id);
    }
}


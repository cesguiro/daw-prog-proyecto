package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import com.cipfpmislata.proyecto3evaluacion.database.DBUtil;
import com.cipfpmislata.proyecto3evaluacion.database.TableNames;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.exception.ResourceNotFoundException;
import com.cipfpmislata.proyecto3evaluacion.persistence.ProductRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

public class ProductRepositoryImplJDBCTemplate implements ProductRepository {

    private final TableNames tableName = TableNames.PRODUCTS;
    private JdbcTemplate jdbcTemplate;


    public ProductRepositoryImplJDBCTemplate() {
        this.jdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
    }
    public void setDatasource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product read(int id) throws ResourceNotFoundException {
        String sql = "SELECT * FROM " + tableName.name().toLowerCase() + " WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper(), id);
        if(products.isEmpty())
            throw new ResourceNotFoundException("");
        return products.get(0);
    }

    @Override
    public List<Product> getByCategoryId(int category_id) {
        String sql = "SELECT * FROM " + tableName.name().toLowerCase() + " WHERE category_id = ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), category_id);
    }
}

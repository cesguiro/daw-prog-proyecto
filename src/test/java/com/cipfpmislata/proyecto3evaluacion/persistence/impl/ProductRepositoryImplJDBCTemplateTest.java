package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryImplJDBCTemplateTest {

    private static ProductRepositoryImplJDBCTemplate productRepository;

    @BeforeAll
    static void setup() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/tables.sql")
                .addScript("db/sql/test_data.sql")
                .build();
        productRepository = new ProductRepositoryImplJDBCTemplate();
        productRepository.setDatasource(dataSource);
    }

    @Test
    public void givenExistingProductId_shouldReturnProduct() throws ResourceNotFoundException {
        // Call method under test
        Product product = productRepository.read(1);

        // Verify results
        assertAll(
            () -> assertEquals(1, product.getId()),
            () -> assertEquals("Product1", product.getName()),
            () -> assertEquals(new BigDecimal("11.11"), product.getPrice())
        );
    }

    @Test
    public void givenExistingProductId_shouldThrowException() throws ResourceNotFoundException {
        // Verify results
        assertThrows(ResourceNotFoundException.class, () -> productRepository.read(-1));
    }
}
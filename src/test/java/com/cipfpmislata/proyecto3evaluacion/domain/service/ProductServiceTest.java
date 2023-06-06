package com.cipfpmislata.proyecto3evaluacion.domain.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Product;
import com.cipfpmislata.proyecto3evaluacion.domain.service.impl.ProductServiceImpl;
import com.cipfpmislata.proyecto3evaluacion.exception.ResourceNotFoundException;
import com.cipfpmislata.proyecto3evaluacion.persistence.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;
    
    private Product expectedProduct;

    @BeforeEach
    void setup(){
        this.expectedProduct = new Product(1, "BrandTest", "NameTest", "DescriptionTest", new BigDecimal(10.00), 0);
    }

    @DisplayName("Prova de read(int)")
    @Test
    public void givenExistingId_shouldReturnProduct() throws ResourceNotFoundException {

        // Configurem les accions del objecte Mock
        when(productRepository.read(expectedProduct.getId())).thenReturn(expectedProduct);

        Product actual = productService.read(expectedProduct.getId());

        assertSame(expectedProduct, actual);
    }

    @DisplayName("Prova de read(int)")
    @Test
    public void givenNonExistingId_ShouldThrowException() throws ResourceNotFoundException {

        // Configurem les accions del objecte Mock
        when(productRepository.read(-1)).thenThrow(
            ResourceNotFoundException.class
        );

        assertThrows(
            ResourceNotFoundException.class,
            () -> productService.read(-1),
            "Expected ResourceNotFound exception, but it was not thrown."
        );
    }
}

package com.portfolio.ecommerce.product.service;

import com.portfolio.ecommerce.product.exception.domain.ProductNotFoundException;
import com.portfolio.ecommerce.product.model.Product;
import com.portfolio.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnProduct_whenProductExists() {

        // GIVEN
        Product product = new Product();
        product.setId("D");
        product.setName("Laptop");

        when(repository.findById("1D"))
                .thenReturn(Optional.of(product));

        // WHEN
        Product result = service.getById("1D");

        // THEN
        assertNotNull(result);
        assertEquals("1D", result.getId());
        assertEquals("Laptop", result.getName());
    }

    @Test
    void shouldThrowException_whenProductNotFound() {

        // GIVEN
        when(repository.findById("1D"))
                .thenReturn(Optional.empty());

        // WHEN + THEN
        assertThrows(ProductNotFoundException.class, () -> {
            service.getById("1D");
        });
    }
}
package com.portfolio.ecommerce.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.ecommerce.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}

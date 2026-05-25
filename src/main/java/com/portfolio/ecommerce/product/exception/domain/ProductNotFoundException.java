package com.portfolio.ecommerce.product.exception.domain;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String id){
        super("Producto no encontrado");
    }
}
package com.portfolio.ecommerce.product.dto.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private Double price;

    public ProductResponse(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

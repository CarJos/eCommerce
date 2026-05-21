package com.portfolio.ecommerce.product.dto.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private String shortDescription;
    private Double price;
    private Integer stock;
    private String categoryId;
}

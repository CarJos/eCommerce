package com.portfolio.ecommerce.product.dto.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private String shortDescription;
    private Double price;
    private Integer stock;
    private Boolean active;

    private String categoryName;

    private List<String> images;

    private Map<String, String> attributes;

    private Double rating;
}

package com.portfolio.ecommerce.product.mapper;

import com.portfolio.ecommerce.product.dto.request.ProductRequest;
import com.portfolio.ecommerce.product.dto.response.ProductResponse;
import com.portfolio.ecommerce.product.model.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }

    public static ProductResponse toResponse(Product product){
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getPrice());
    }
}

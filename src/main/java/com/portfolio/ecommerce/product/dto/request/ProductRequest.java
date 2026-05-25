package com.portfolio.ecommerce.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double price;
}

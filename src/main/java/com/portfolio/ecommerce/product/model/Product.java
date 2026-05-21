package com.portfolio.ecommerce.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;          // ID único

    private String name;        // Nombre del producto
    private String description; // Descripción larga
    private String shortDescription; // Descripción corta
    private double price;       // Precio base
    private String sku;         // SKU
    private int stock;          // Cantidad disponible
    private boolean active;     // Estado (activo/inactivo)
}

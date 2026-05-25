package com.portfolio.ecommerce.product.controller;

import com.portfolio.ecommerce.product.dto.request.ProductRequest;
import com.portfolio.ecommerce.product.dto.response.ProductResponse;
import com.portfolio.ecommerce.product.mapper.ProductMapper;
import com.portfolio.ecommerce.product.model.Product;
import com.portfolio.ecommerce.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request){
        ProductResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product){
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}

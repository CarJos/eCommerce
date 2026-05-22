package com.portfolio.ecommerce.product.service;

import com.portfolio.ecommerce.product.model.Product;
import com.portfolio.ecommerce.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public Product create(Product product){
        return repository.save(product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getById(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encotrado"));
    }

    public Product update(String id, Product updated){
        Product product = getById(id);
        product.setName(updated.getName());
        product.setPrice(updated.getPrice());

        return repository.save(product);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}

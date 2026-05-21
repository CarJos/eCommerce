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

    public Product getById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encotrado"));
    }

    public Product update(Long id, Product updated){
        Product product = getById(id);
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setShortDescription(updated.getShortDescription());
        product.setPrice(updated.getPrice());
        product.setSku(updated.getSku());
        product.setStock(updated.getStock());
        product.setActive(updated.isActive());

        return repository.save(product);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

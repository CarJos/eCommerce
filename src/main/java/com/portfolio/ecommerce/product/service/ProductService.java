package com.portfolio.ecommerce.product.service;

import com.portfolio.ecommerce.product.dto.request.ProductRequest;
import com.portfolio.ecommerce.product.dto.response.ProductResponse;
import com.portfolio.ecommerce.product.exception.domain.ProductNotFoundException;
import com.portfolio.ecommerce.product.mapper.ProductMapper;
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

    public ProductResponse create(ProductRequest request){
        Product product = ProductMapper.toEntity(request);
        Product saved = repository.save(product);
        return ProductMapper.toResponse(saved);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getById(String id){
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
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

package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository _productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this._productRepository = productRepository;
    }

    public List<Products> getProducts(){
        return _productRepository.findAll();
    }

    public void addNewProducts(Products products) {
        _productRepository.save(products);
    }


    public void delete(Integer ProductId) {
        _productRepository.deleteById(ProductId);
    }

    public Optional<Products> findById(Integer productId) {
       return _productRepository.findById(productId);
    }

}

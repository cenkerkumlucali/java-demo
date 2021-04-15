package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository _productRepository;

    @Autowired
    public ProductService(ProductRepository _productRepository) {
        this._productRepository = _productRepository;
    }

    public List<Products> getProducts(){
        return _productRepository.findAll();
    }

    public void addNewProducts(Products products) {
        _productRepository.save(products);
    }

}

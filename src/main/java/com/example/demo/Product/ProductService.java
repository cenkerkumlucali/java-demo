package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        System.out.println("Ürün eklendi");
    }

    public void delete(Integer ProductId) {

        if(productsExist(ProductId)){

            _productRepository.deleteById(ProductId);
            System.out.println("Ürün silindi");
        }
        else{
            throw new IllegalStateException("product with id " + ProductId + " does not exists");
        }

    }

    public Optional<Products> findById(Integer productId) {
       return _productRepository.findById(productId);
    }

    public List<Products> findByCategoryId(Integer categoryId) {
        return _productRepository.findProductsByCategoryId(categoryId);
    }

    private boolean productNameExist(String productName){
     var result = _productRepository.findProductsByProductName(productName).isPresent();
        if(result){
            return true;
        }
        return false;
    }

    private boolean productsExist(Integer ProductId){
        var exists = _productRepository.existsById(ProductId);
        if(exists){
            return true;
        }
        return false;
    }

    private boolean checkProductByUnitPrice(Integer UnitPrice){
        if (UnitPrice < 50){
            return  true;
        }
        return false;
    }



}

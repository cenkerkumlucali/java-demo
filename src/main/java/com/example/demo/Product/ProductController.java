package com.example.demo.Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping(path="api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getProducts(){
    return productService.getProducts();
    }

    @GetMapping(path = "{ProductId}")
    public Optional<Products> FilterById(@PathVariable Integer ProductId){
        return productService.findById(ProductId);
    }

    @PostMapping
    public void add(@RequestBody Products products){
        productService.addNewProducts(products);
    }

    @DeleteMapping(path = "{ProductId}")
    public void deleteShoes(@PathVariable("ProductId")Integer ProductId){
        productService.delete(ProductId);
    }



}

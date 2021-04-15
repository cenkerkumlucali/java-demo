package com.example.demo.Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public void registerNewShoe(@RequestBody Products products){
        productService.addNewProducts(products);
    }

}

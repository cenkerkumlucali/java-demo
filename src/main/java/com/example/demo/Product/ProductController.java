package com.example.demo.Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }
    @GetMapping("api/v1/products")
    public List<Products> getProducts(){
    return productService.getProducts();
    }

    @GetMapping(path = "api/v1/products/{ProductId}")
    public Optional<Products> FilterById(@PathVariable Integer ProductId){
        return productService.findById(ProductId);
    }

    @GetMapping(path = "api/v1/products/Category/{CategoryId}")
    public List<Products> FilterByCategoryId(@PathVariable Integer CategoryId){
        return productService.findByCategoryId(CategoryId);
    }

    @PostMapping("api/v1/products/add")
    public void add(@RequestBody Products products){
        productService.addNewProducts(products);
    }

    @DeleteMapping(path = "api/v1/products/{ProductId}")
    public void deleteProducts(@PathVariable("ProductId")Integer ProductId){
        productService.delete(ProductId);
    }

    @PutMapping("api/v1/products/{ProductId}")
    public Products updateProducts(@PathVariable("ProductId")Integer ProductId, @RequestBody Products products){
        return productRepository.findById(ProductId)
                .map(product -> {
                    products.setProductName(products.getProductName());
                    product.setCategoryId(product.getCategoryId());
                    product.setUnitPrice(product.getUnitPrice());
                    product.setUnitsInStock(product.getUnitsInStock());
                    return productRepository.save(products);
                })
                .orElseGet(() -> {
                    products.setProductId(ProductId);
                    return productRepository.save(products);
                });
    }
}

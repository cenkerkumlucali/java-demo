package com.example.demo.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller

public class CategoryController {
    private final CategoryService _categoryService;

    public CategoryController(CategoryService categoryService) {
        _categoryService = categoryService;
    }


    @GetMapping("api/v1/category")
    public List<Category> getCategories(){
        return _categoryService.getCategory();
    }
    @GetMapping("api/v1/category/{CategoryId}")
    public Optional<Category> getCategoryById(@PathVariable Integer CategoryId){
        return _categoryService.getCategoryById(CategoryId);
    }
    @PostMapping("api/v1/category/add")
    public void add(@RequestBody Category category){
        _categoryService.addCategory(category);
    }
    @DeleteMapping(path = "api/v1/category/{CategoryId}")
    public void delete(@PathVariable("CategoryId") Integer CategoryId){_categoryService.deleteCategory(CategoryId);}
}

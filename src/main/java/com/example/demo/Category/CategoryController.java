package com.example.demo.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller

public class CategoryController {
    private final CategoryService _categoryService;
    private final CategoryRepository _categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        _categoryService = categoryService;
        _categoryRepository = categoryRepository;
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
    @PutMapping("api/v1/category/{CategoryId}")
    public Category update(@PathVariable("CategoryId")Integer CategoryId,@RequestBody Category category){
        return _categoryRepository.findById(CategoryId)
                .map(category1 -> {
                    category1.setCategoryName(category.getCategoryName());
                    return _categoryRepository.save(category);
                })
                .orElseGet(() -> {
            category.setCategoryId(CategoryId);
            return _categoryRepository.save((category));
        });
    }
}

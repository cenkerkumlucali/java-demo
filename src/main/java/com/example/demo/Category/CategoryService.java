package com.example.demo.Category;


import com.example.demo.Product.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository _categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        _categoryRepository = categoryRepository;
    }

    public List<Category> getCategory(){
        return _categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(Integer categoryId){
        return _categoryRepository.findById(categoryId);
    }
    public void addCategory(Category category){
        _categoryRepository.save(category);
    }
    public void deleteCategory(Integer CategoryId){_categoryRepository.deleteById(CategoryId);}
}

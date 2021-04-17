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

        if(categoryNameExist(category.CategoryName)){
            throw new IllegalStateException("Aynı isimde kategory ismi olamaz!");
        }
        _categoryRepository.save(category);
        System.out.println("Kategory başarılayla eklendi.");
    }
    public void deleteCategory(Integer CategoryId){_categoryRepository.deleteById(CategoryId);}

    private boolean categoryNameExist(String categoryName){
       var result= _categoryRepository.findCategoryByCategoryName(categoryName).isPresent();
        if(result){
            return true;
        }
        return false;
    }
}

package com.example.demo.Category;

import com.example.demo.Product.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.CategoryName=?1")
    Optional<Category> findCategoryByCategoryName(String CategoryName);
}

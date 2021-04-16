package com.example.demo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    @Query("SELECT s FROM Products s WHERE s.CategoryId=?1")
    List<Products> findProductsByCategoryId(Integer CategoryId);
}

package com.example.demo.Category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    public int CategoryId;
    public String CategoryName;

    public Category(){}
    public Category(int categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}

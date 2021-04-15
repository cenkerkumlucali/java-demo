package com.example.demo;

public class Product {
    int ProductId;
    int CategoryId;
    String ProductName;
    int UnitsInStock;
    int UnitPrice;

    public Product(int ProductId, int CategoryId, String ProductName, int UnitsInStock, int UnitPrice) {
        this.ProductId = ProductId;
        this.CategoryId = CategoryId;
        this.ProductName = ProductName;
        this.UnitsInStock = UnitsInStock;
        this.UnitPrice = UnitPrice;
    }
}

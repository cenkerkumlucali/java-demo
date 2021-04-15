package com.example.demo.Product;

import javax.persistence.*;

@Entity
@Table
public class Products {

    @Id

    public int ProductId;
    public int CategoryId;
    public String ProductName;
    public int UnitsInStock;
    public int UnitPrice;

    public Products() {

    }
    public Products(int CategoryId, String ProductName, int UnitsInStock, int UnitPrice) {
        this.CategoryId = CategoryId;
        this.ProductName = ProductName;
        this.UnitsInStock = UnitsInStock;
        this.UnitPrice = UnitPrice;
    }
    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        UnitsInStock = unitsInStock;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }

}

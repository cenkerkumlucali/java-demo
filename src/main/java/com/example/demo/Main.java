package com.example.demo;

import ch.qos.logback.core.db.DBHelper;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        SelectDemo();
    }
    public static void DeleteData() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from products where ProductId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,6);
            statement.executeUpdate();
            System.out.println("Kayıt silindi");
        } catch (SQLException sqlException) {
            dbHelper.ShowErrorMessage(sqlException);
        } finally {
            statement.close();
            connection.close();
        }
        SelectDemo();

    }
    public static void UpdateData() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            String sql = "update products set ProductName=?,CategoryId=?,UnitsInStock=?,UnitPrice=? where ProductId=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(5,6);
            statement.setString(1,"Defter1");
            statement.setInt(2,5);
            statement.setInt(3,3);
            statement.setInt(4,20);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi");
        } catch (SQLException sqlException) {
            dbHelper.ShowErrorMessage(sqlException);
        } finally {
            statement.close();
            connection.close();
        }
        SelectDemo();
    }
    public static void InsertData() throws SQLException{
    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement statement = null;
    ResultSet resultSet;
    try {
        connection = dbHelper.getConnection();
        String sql = "INSERT INTO `northwind`.`products`" + "(`ProductId`, `CategoryId`, `ProductName`, `UnitsInStock`, `UnitPrice`)" + "VALUES (?, ?, ?, ?,?);";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,6);
        statement.setInt(2,2);
        statement.setString(3,"Defter");
        statement.setInt(4,10);
        statement.setInt(5,25);
        statement.executeUpdate();
        System.out.println("Kayıt eklendi");
    } catch (SQLException sqlException) {
        dbHelper.ShowErrorMessage(sqlException);
    } finally {
        statement.close();
        connection.close();
    }
    SelectDemo();
}
    public static void SelectDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM northwind.products");
            ArrayList<Product> products = new ArrayList<Product>();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("ProductId"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getString("ProductName"),
                        resultSet.getInt("UnitsInStock"),
                        resultSet.getInt("UnitPrice")));
            }
            for (Product x : products) {
                System.out.println(x.ProductId+" "+x.CategoryId+" "+x.ProductName + " "+x.UnitsInStock+" " + x.UnitPrice);
            }
        } catch (SQLException sqlException) {
            dbHelper.ShowErrorMessage(sqlException);
        } finally {
            connection.close();
        }
    }
}

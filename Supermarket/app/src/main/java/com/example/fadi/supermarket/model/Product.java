package com.example.fadi.supermarket.model;

/**
 * Created by Fadi on 5/4/2018.
 */

import java.util.Date;
import java.util.List;

public class Product {

    int id;
    double price;
    String name;
    private Date added;
    private double sale;
    private ProductCategory category;
    private String image;

    public Product(double price, String name, Date added, double sale, String image, ProductCategory category) {
        this.price = price;
        this.name = name;
        this.added = added;
        this.category = category;
        this.sale = sale;
        this.image = image;
    }

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
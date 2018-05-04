package com.example.fadi.supermarket.model;

/**
 * Created by Fadi on 5/4/2018.
 */

public class Coupon {

    int id;
    String name;
    String description;


    public Coupon(int id, String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;

    }

    public Coupon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
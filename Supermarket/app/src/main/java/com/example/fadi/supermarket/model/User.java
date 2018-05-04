package com.example.fadi.supermarket.model;

/**
 * Created by Fadi on 5/4/2018.
 */

public class User {
    String name;
    String password;
    String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

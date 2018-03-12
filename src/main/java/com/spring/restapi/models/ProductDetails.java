package com.spring.restapi.models;

public class ProductDetails {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductDetails(String title) {
        this.title = title;
    }
}

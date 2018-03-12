package com.spring.restapi.models;

public class ProductResponse {
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    Product product;

    public ProductResponse(Product product) {
        this.product = product;
    }
}

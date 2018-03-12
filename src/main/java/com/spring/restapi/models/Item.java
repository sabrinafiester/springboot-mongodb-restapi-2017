package com.spring.restapi.models;

public class Item {
    String tcin;

    public String getTcin() {
        return tcin;
    }

    public void setTcin(String tcin) {
        this.tcin = tcin;
    }

    ProductDetails product_description;
    Price price;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ProductDetails getItem() {
        return product_description;
    }

    public void setItem(ProductDetails product_description) {
        this.product_description = product_description;
    }

    public Item(String tcin, ProductDetails product_description, Price price) {
        this.tcin = tcin;
        this.product_description = product_description;
        this.price = price;
    }
}

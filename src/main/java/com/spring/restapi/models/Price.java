package com.spring.restapi.models;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "prices")
public class Price {
    String tcin;
    Double price;
    Double offerPrice;
    Long offerStart;
    Long offerEnd;


    public Price() {
    }

    public Price(String tcin, Double price, Double offerPrice, Long offerStart, Long offerEnd) {
        this.tcin = tcin;
        this.price = price;
        this.offerPrice = offerPrice;
        this.offerStart = offerStart;
        this.offerEnd = offerEnd;
    }

    public String getTcin() {
        return tcin;
    }

    public void setTcin(String tcin) {
        this.tcin = tcin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Long getOfferStart() {
        return offerStart;
    }

    public void setOfferStart(Long offerStart) {
        this.offerStart = offerStart;
    }

    public Long getOfferEnd() {
        return offerEnd;
    }

    public void setOfferEnd(Long offerEnd) {
        this.offerEnd = offerEnd;
    }

    @Override
    public String toString() {
        return "Price{" +
                ", List Price='" + price + '\'' +
                ", Offer Price='" + offerPrice + '\'' +
                '}';
    }
}

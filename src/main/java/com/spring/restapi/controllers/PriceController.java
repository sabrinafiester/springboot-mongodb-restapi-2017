package com.spring.restapi.controllers;

import com.google.gson.Gson;
import com.spring.restapi.models.Price;
import com.spring.restapi.models.ProductResponse;
import com.spring.restapi.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @Autowired
    PriceRepository priceRepository;

    ProductClient productClient = new ProductClient();
    Gson gson = new Gson();


    @RequestMapping(method=RequestMethod.GET, value="/prices")
    public Iterable<Price> prices() {
        return priceRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public String getOne(@PathVariable String id) {
        String productJson = productClient.getProduct(id);
        ProductResponse productRe = gson.fromJson(productJson, ProductResponse.class);
        Price priceObj = priceRepository.findPriceBytcin(id);
        productRe.getProduct().getItem().setPrice(priceObj);
        return gson.toJson(productRe);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Price update(@PathVariable String id, @RequestBody Price productPrice) {
        Price priceObj = priceRepository.findPriceBytcin(id);
        if(productPrice.getPrice() != null)
            priceObj.setPrice(productPrice.getPrice());
        if(productPrice.getOfferPrice() != null)
            priceObj.setOfferPrice(productPrice.getOfferPrice());
        if(productPrice.getOfferStart() != null)
            priceObj.setOfferStart(productPrice.getOfferStart());
        if(productPrice.getOfferEnd() != null)
            priceObj.setOfferEnd(productPrice.getOfferEnd());
        priceRepository.save(priceObj);
        return priceObj;
    }

    @RequestMapping(method=RequestMethod.POST, value="/prices")
    public String save(@RequestBody Price price) {
        priceRepository.save(price);

        return price.getTcin();
    }


}
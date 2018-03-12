package com.spring.restapi.controllers;

import org.springframework.web.client.RestTemplate;




public class ProductClient {
    private static final String PRODUCT_URI = "http://redsky.target.com/v2/pdp/tcin/";
    private RestTemplate restTemplate = new RestTemplate();

    /**
     *
     * get a particular Product
     * @param productId
     * @return
     */
    String getProduct(String productId) {
        String product = restTemplate.getForObject(PRODUCT_URI + "/{productId}", String.class, productId);

        return product;
    }
}

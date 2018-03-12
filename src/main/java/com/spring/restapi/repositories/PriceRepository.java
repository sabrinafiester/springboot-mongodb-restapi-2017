package com.spring.restapi.repositories;


import com.spring.restapi.models.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<Price, String> {

    Price findPriceBytcin(String tcin);

}
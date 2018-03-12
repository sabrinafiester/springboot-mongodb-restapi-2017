package com.spring.restapi.controllers;

import com.google.gson.Gson;
import com.spring.restapi.RestapiApplication;
import com.spring.restapi.models.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {

    @LocalServerPort
    int port = 8080;
    private String getBaseUrl() {
        return "http://localhost:" + port;
    }

    TestRestTemplate restTemplate = new TestRestTemplate();
    Gson gson = new Gson();

    @Test
    void prices() {
        ResponseEntity<Price[]> responseEntity = restTemplate.getForEntity(getBaseUrl()+"/prices", Price[].class);
        Price[] prices = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertEquals(statusCode.value(), 200);
    }

    @Test
    void findOne() {
        String testId = "52146578";
        ProductResponse expectedResponse = new ProductResponse(new Product());
        Price testPrice = new Price("52146578", 69.99,66.49,1520150400000L,1520755200000L);
        ProductDetails testDetails = new ProductDetails("Star Wars Poe Dameron The Black Series Electronic X-Wing Pilot Helmet");
        expectedResponse.getProduct().setItem(new Item(testId, testDetails, testPrice));
        String expected = gson.toJson(expectedResponse);

        String response = restTemplate.getForObject(getBaseUrl()+"/products/52146578", String.class);

        assertEquals(expected, response);
    }

    @Test
    void update() {

    }

    @Test
    void save() {
    }
}


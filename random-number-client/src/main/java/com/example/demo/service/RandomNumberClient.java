package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RandomNumberClient {

    private final RestTemplate restTemplate;

    @Autowired
    public RandomNumberClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRandomNumber() {
        String url = "http://localhost:8080/random-number"; 
        return restTemplate.getForObject(url, String.class);
    }
}

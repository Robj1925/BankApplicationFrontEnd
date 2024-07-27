package com.example.demo.controller;

import com.example.demo.service.RandomNumberClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class RandomNumberClientController {

    private final RandomNumberClient randomNumberClient;

    @Autowired
    public RandomNumberClientController(RandomNumberClient randomNumberClient) {
        this.randomNumberClient = randomNumberClient;
    }

    @GetMapping("/random-number")
    public ResponseEntity<String> getRandomNumberFromClient() {
        String randomNumber = randomNumberClient.getRandomNumber();
        return ResponseEntity.ok(randomNumber);
    }
}

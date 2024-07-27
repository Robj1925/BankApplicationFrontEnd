package com.example.demo.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {
	@GetMapping("/random-number2")
	public String getRandomNumber() {
		Random rand = new Random();
		return "Second number: " + rand.nextInt();
	}

}

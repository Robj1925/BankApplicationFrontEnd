package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Customer {
	@Id
	@GeneratedValue
	private long customerId;
	private String name;
	private String streetNumber;
	private String city;
	private String providence;
	private String postalCode;

}

package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class CheckingAccount extends Account {
	@NotNull
	private int nextCheckNumber;

	public CheckingAccount() {
		
	}

	public CheckingAccount(double balance, Customer customer, @NotNull int nextCheckNumber) {
		super(balance, customer);
		this.nextCheckNumber = nextCheckNumber;
	}
	
}

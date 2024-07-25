package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class SavingsAccount extends Account {
	@NotNull
	private double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(double balance, Customer customer, double interestRate) {
		super(balance, customer);
		this.interestRate = interestRate;
	}

}

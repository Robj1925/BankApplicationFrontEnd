package com.example.demo.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity(name="Company")
@DiscriminatorValue(value = "Company")
public class Company extends Customer {

	public Company() {
		super();
	}

	public Company(@NotNull String name, Address address, List<Account> accounts) {
		super(name, address, accounts);
	}


}

package com.example.demo.model;

import java.util.List;

// import com.example.demo.service.Account;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity(name="Person")
@DiscriminatorValue(value = "Person")

public class Person extends Customer {
	public Person() {
		super();
	}

	public Person(@NotNull String name, Address address, List<Account> list) {
		super(name, address, list);
	}
}

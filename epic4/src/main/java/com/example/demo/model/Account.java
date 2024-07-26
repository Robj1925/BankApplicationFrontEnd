package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private double balance;
	@ManyToOne
	@JoinColumn(name = "fk_customer_id")
	private Customer customer;

	public Account(double balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
	}

	public Account() {
		super();
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

}

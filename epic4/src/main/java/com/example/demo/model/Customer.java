package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUSTOMER_TYPE", discriminatorType = DiscriminatorType.STRING)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
public abstract class Customer {
	@Id
	@GeneratedValue
	private long customerId;
	@NotNull
	private String name;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_add_id")
	private Address address;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> accounts;

	public Customer(@NotNull String name, Address address, List<Account> accounts ) {
		super();
		this.name = name;
		this.address = address;
		this.accounts = accounts;
	}

	public Customer() {
		super();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}

	public void setId(long l) {
		this.customerId = l;
	}

}

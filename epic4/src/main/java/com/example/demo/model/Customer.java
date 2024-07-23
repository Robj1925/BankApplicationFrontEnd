package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long customerId;
	@NotNull
	private String name;
////	@NotNull
//	private String streetNumber;
////	@NotNull
//	private String city;
//	//@NotNull
//	private String providence;
////	@NotNull
//	private String postalCode;
	//@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_add_id")
	private Address address;
	
	public Customer(@NotNull String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
//	public Customer(String name, String streetNumber, String city, String providence, String postalCode) {
//		super();
//		this.name = name;
//		this.streetNumber = streetNumber;
//		this.city = city;
//		this.providence = providence;
//		this.postalCode = postalCode;
//	}
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
//	public String getStreetNumber() {
//		return streetNumber;
//	}
//	public void setStreetNumber(String streetNumber) {
//		this.streetNumber = streetNumber;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getProvidence() {
//		return providence;
//	}
//	public void setProvidence(String providence) {
//		this.providence = providence;
//	}
//	public String getPostalCode() {
//		return postalCode;
//	}
//	public void setPostalCode(String postalCode) {
//		this.postalCode = postalCode;
//	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}
	

}

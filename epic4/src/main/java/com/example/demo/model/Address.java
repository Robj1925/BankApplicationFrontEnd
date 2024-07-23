package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "add_id")
	private long addressId;
	@NotNull
	private String streetNumber;
	@NotNull
	private String postalCode;
	@NotNull
	private String city;
	@NotNull
	private String providence;
	@OneToOne(mappedBy="address")
	Customer customer;
	
	public Address(String streetNumber, String postalCode, String city, String providence) {
		super();
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.providence = providence;
	}
	
	public Address() {
		super();
	}

	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvidence() {
		return providence;
	}
	public void setProvidence(String providence) {
		this.providence = providence;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode
				+ ", city=" + city + ", providence=" + providence + ", customer=" + customer + "]";
	}
	

}

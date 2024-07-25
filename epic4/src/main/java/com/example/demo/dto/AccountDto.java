package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class AccountDto {
	@NotNull
	private double balance;
	private String accountType;
	private long customerId; 
    private double interestRate;
    private int nextCheckNumber;
    
	public AccountDto() {
		super();
	}

	public AccountDto(double balance, String accountType, long customerId, double interestRate, int nextCheckNumber) {
		super();
		this.balance = balance;
		this.accountType = accountType;
		this.customerId = customerId;
		this.interestRate = interestRate;
		this.nextCheckNumber = nextCheckNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}
	
    

}

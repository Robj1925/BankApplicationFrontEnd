package com.fdmgroup.javaDocExercises;

/**
 * A BankAccount represents a bank account that would be used in a bank.
 * All BankAccounts have an account number, name associated to the account, and a running balance.
 * The bank account is also to perform functions such as depositing money or withdrawing money.
 * 
 *  @author FDMGroup
 *  @version 1.0
 */

public class BankAccount {
	private int accountNumber;
	private String accountName;
	private double balance;
	public BankAccount(int accountNumber, String accountName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
	}
	public BankAccount() {
		super();
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * Subtracts amount from balance, exception thrown if amount is greater than the balance;
	 * @param amount to be subtracted from balance
	 * @throws InvalidAccountException 
	 * 		thrown if not enough funds in account for withdrawal.
	 * @see InvalidAccountException
	 */
	public void withdraw(double amount) throws InsufficientFundsException, InvalidAccountException {
		if (amount > this.balance) {
			throw new InvalidAccountException("Amount cannot be greater than balance!");
		}
		this.balance -= amount;
		
	}
	/**
	 * Adds amount to balance
	 * @param amount to be added to balance;
	 */
	public void deposit(double amount) {
		amount += balance;
	}
	
	
}

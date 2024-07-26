package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.CheckingAccount;
import com.example.demo.model.Customer;
import com.example.demo.model.SavingsAccount;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository accountRepository;
	private CustomerService customerService;

	public AccountService(AccountRepository accountRepository, CustomerService customerService) {
		super();
		this.accountRepository = accountRepository;
		this.customerService = customerService;
	}

	public Account createAccount(AccountDto accountDto) throws CustomerNotFoundException {
		Account account = null;
		Customer customer = customerService.findById(accountDto.getCustomerId());

		if (accountDto.getAccountType().equalsIgnoreCase("savings")) {
			account = new SavingsAccount(accountDto.getBalance(), customer, accountDto.getInterestRate());
		} else if (accountDto.getAccountType().equalsIgnoreCase("checking")) {
			account = new CheckingAccount(accountDto.getBalance(), customer, accountDto.getNextCheckNumber());
		} else {
			throw new IllegalArgumentException("Invalid account type");
		}
		customer.getAccounts().add(account);
		return accountRepository.save(account);

	}

	public List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}

	public List<Account> getAllAccountsOfCustomersInToronto() {

		List<Customer> customers = customerService.getAllCustomersInToronto();
		
		List<Account> accounts = new ArrayList<>();
		for (Customer customer : customers) {
			accounts.addAll(customer.getAccounts());
		}
		return accounts;

	}
}

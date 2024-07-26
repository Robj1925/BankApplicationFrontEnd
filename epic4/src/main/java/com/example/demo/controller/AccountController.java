package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    
    public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto) {
        try {
            Account createdAccount = accountService.createAccount(accountDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } catch (CustomerNotFoundException | IllegalArgumentException e) {
        	e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.findAllAccounts());
    }
    @GetMapping("/by-city-in-toronto")
    public ResponseEntity<List<Account>> getAccountsByCustomersInToronto() {
        List<Account> accounts = accountService.getAllAccountsOfCustomersInToronto();
        return ResponseEntity.ok(accounts);
    }
}

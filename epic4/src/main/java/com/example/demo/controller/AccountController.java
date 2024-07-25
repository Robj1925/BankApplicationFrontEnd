package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import exception.CustomerNotFoundException;
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
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
//        try {
//            Account account = accountService.findById(id);
//            return ResponseEntity.ok(account);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {
//        try {
//            Account updatedAccount = accountService.updateAccount(id, accountDto);
//            return ResponseEntity.ok(updatedAccount);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
//        try {
//            accountService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}

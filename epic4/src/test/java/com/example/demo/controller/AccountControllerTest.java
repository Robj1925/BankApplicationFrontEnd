package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.Address;
import com.example.demo.model.CheckingAccount;
import com.example.demo.model.Customer;
import com.example.demo.model.Person;
import com.example.demo.model.SavingsAccount;
import com.example.demo.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    private AccountDto savingsAccountDto;
    private AccountDto checkingAccountDto;
    private Customer customer;
    private List<Account> accounts;

    @BeforeEach
    void setUp() {
        customer = new Person("John Doe", new Address("123 Street", "A1B 2C3", "Toronto", "ON"), new ArrayList<>());
        customer.setCustomerId(1L);

        savingsAccountDto = new AccountDto(1000.0, "savings", customer.getCustomerId(), 0.01, 0);
        checkingAccountDto = new AccountDto(1500.0, "checking", customer.getCustomerId(), 0.0, 1001);

        Account savingsAccount = new SavingsAccount(savingsAccountDto.getBalance(), customer, savingsAccountDto.getInterestRate());
        savingsAccount.setId(1L);

        Account checkingAccount = new CheckingAccount(checkingAccountDto.getBalance(), customer, checkingAccountDto.getNextCheckNumber());
        checkingAccount.setId(2L);

        accounts = new ArrayList<>();
        accounts.add(savingsAccount);
        accounts.add(checkingAccount);
    }

    @Test
    void test_CreateAccount_ReturnsSavingsAccountWhenSavingsAccountTypeIsSpecified() throws Exception {
        when(accountService.createAccount(any(AccountDto.class))).thenReturn(accounts.get(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(savingsAccountDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.balance").value(savingsAccountDto.getBalance()));
    }

    @Test
    void test_CreateAccount_ThrowsCustomerNotFound() throws Exception {
        when(accountService.createAccount(any(AccountDto.class))).thenThrow(new CustomerNotFoundException("Customer not found"));

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(savingsAccountDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test_GetAllAccounts_ReturnsListOfAccounts_WhenListHasAccounts() throws Exception {
        when(accountService.findAllAccounts()).thenReturn(accounts);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].balance").value(accounts.get(0).getBalance()))
                .andExpect(jsonPath("$[1].balance").value(accounts.get(1).getBalance()));
    }

    @Test
    void test_GetAccountsByCustomersInToronto_ReturnsAccountsOfCustomersInToronto() throws Exception {
        when(accountService.getAllAccountsOfCustomersInToronto()).thenReturn(accounts);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/by-city-in-toronto")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].balance").value(accounts.get(0).getBalance()))
                .andExpect(jsonPath("$[1].balance").value(accounts.get(1).getBalance()));
    }
}

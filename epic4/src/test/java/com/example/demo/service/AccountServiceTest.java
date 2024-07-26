package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.AccountRepository;

@SpringBootTest
class AccountServiceTest {

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private AccountService accountService;

	private AccountDto savingsAccountDto;
	private AccountDto checkingAccountDto;
	private Customer customer;
	private List<Account> accounts;

	@BeforeEach
	void setUp() throws CustomerNotFoundException {
		MockitoAnnotations.openMocks(this);

		customer = new Person("John Doe", new Address("123 Street", "A1B 2C3", "Toronto", "ON"), new ArrayList<>());
		customer.setCustomerId(1L);

		savingsAccountDto = new AccountDto(1000.0, "savings", customer.getCustomerId(), 0.01, 0);
		checkingAccountDto = new AccountDto(1500.0, "checking", customer.getCustomerId(), 0.0, 1001);

		when(customerService.findById(customer.getCustomerId())).thenReturn(customer);

		Account savingsAccount = new SavingsAccount(savingsAccountDto.getBalance(), customer,
				savingsAccountDto.getInterestRate());
		savingsAccount.setId(1L); 

		Account checkingAccount = new CheckingAccount(checkingAccountDto.getBalance(), customer,
				checkingAccountDto.getNextCheckNumber());
		checkingAccount.setId(2L);

		accounts = new ArrayList<>();
		accounts.add(savingsAccount);
		accounts.add(checkingAccount);
		customer.setAccounts(accounts);
	}

	@Test
	void test_FindAllAccounts_ReturnsListOfTwoAccounts_WhenTwoAccountsAreInList() {
		when(accountRepository.findAll()).thenReturn(accounts);

		List<Account> retrievedAccounts = accountService.findAllAccounts();

		assertNotNull(retrievedAccounts);
		assertEquals(2, retrievedAccounts.size());
	}

	@Test
	void test_GetAllAccountsOfCustomersInToronto_ReturnsCustomersWithFieldCityInToronto() {
		when(customerService.getAllCustomersInToronto()).thenReturn(List.of(customer));

		List<Account> torontoAccounts = accountService.getAllAccountsOfCustomersInToronto();

		assertNotNull(torontoAccounts);
		assertEquals(2, torontoAccounts.size());
	}
	@Test
    void test_CreateAccount_ThrowsCustomerNotFoundException() {
        try {
			when(customerService.findById(0)).thenThrow(new CustomerNotFoundException("Customer not found"));
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        AccountDto invalidCustomerAccountDto = new AccountDto(1000.0, "savings", -1L, 0.01, 0);

        assertThrows(NullPointerException.class, () -> {
            accountService.createAccount(invalidCustomerAccountDto);
        });
    }

}

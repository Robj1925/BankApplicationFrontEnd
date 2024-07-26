package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import com.example.demo.dto.CustomerDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CustomerServiceTest {
	@Mock
	CustomerRepository mockCustomerRepository;

	@InjectMocks
	CustomerService customerService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_CreateCustomerPerson_ReturnsSavedCustomerObjectAndCustomerRepositorySaveGetsCalled() {
		CustomerDto dto = new CustomerDto("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), "person");
		Person person = new Person(dto.getName(), dto.getAddress(), new ArrayList<>());

		when(mockCustomerRepository.save(any(Person.class))).thenReturn(person);

		Customer createdCustomer = customerService.createCustomer(dto);

		assertNotNull(createdCustomer);
		assertEquals("John Doe", createdCustomer.getName());
		verify(mockCustomerRepository, times(1)).save(any(Person.class));
	}

	@Test
	void test_CreateCustomerCompany_ReturnsSavedCustomerObjectAndCustomerRepositorySaveGetsCalled() {
		CustomerDto dto = new CustomerDto("Acme Corp", new Address("456", "D4E 5F6", "Toronto", "ON"), "company");
		Company company = new Company(dto.getName(), dto.getAddress(), new ArrayList<>());

		when(mockCustomerRepository.save(any(Company.class))).thenReturn(company);

		Customer createdCustomer = customerService.createCustomer(dto);

		assertNotNull(createdCustomer);
		assertEquals("Acme Corp", createdCustomer.getName());
		verify(mockCustomerRepository, times(1)).save(any(Company.class));
	}

	@Test
	void test_FindAllCustomers_ReturnsListOfTwoCustomers_WhenTwoCustomersAreCreated() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Person("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), new ArrayList<>()));
		customers.add(new Company("Acme Corp", new Address("456", "D4E 5F6", "Toronto", "ON"), new ArrayList<>()));

		when(mockCustomerRepository.findAll()).thenReturn(customers);

		List<Customer> foundCustomers = customerService.findAllCustomers();

		assertNotNull(foundCustomers);
		assertEquals(2, foundCustomers.size());
		verify(mockCustomerRepository, times(1)).findAll();
	}

	@Test
	void test_FindById_ReturnsCustomerWithSpecifiedId_WhenIdIsProvided() throws CustomerNotFoundException {
		Customer customer = new Person("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), new ArrayList<>());

		when(mockCustomerRepository.findById(1L)).thenReturn(Optional.of(customer));

		Customer foundCustomer = customerService.findById(1L);

		assertNotNull(foundCustomer);
		assertEquals("John Doe", foundCustomer.getName());
		verify(mockCustomerRepository, times(1)).findById(1L);
	}

	@Test
	void test_FindById_ThrowsException_WhenCustomerWithIdDoesNotExist() {
		when(mockCustomerRepository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(CustomerNotFoundException.class, () -> customerService.findById(1L));
	}

	@Test
	void test_UpdateCustomer_ReturnsNewPostalCode_WhenPostalCodeIsUpdated() throws CustomerNotFoundException {
		CustomerDto dto = new CustomerDto("Jane Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), "person");
		Customer existingCustomer = new Person("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"),
				new ArrayList<>());
		Customer updatedCustomer = new Person("Jane Doe", new Address("123", "00000", "Toronto", "ON"),
				new ArrayList<>());

		when(mockCustomerRepository.findById(1L)).thenReturn(Optional.of(existingCustomer));
		when(mockCustomerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

		Customer result = customerService.updateCustomer(1L, dto);

		assertNotNull(result);
		assertEquals("00000", result.getAddress().getPostalCode());
		verify(mockCustomerRepository, times(1)).save(any(Customer.class));
	}
	 @Test
	    void test_DeleteById_CallsDeleteByIdRepoMethodOnce() throws CustomerNotFoundException {
	        Customer customer = new Person("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), new ArrayList<>());

	        when(mockCustomerRepository.findById(1L)).thenReturn(Optional.of(customer));

	        customerService.deleteById(1L);

	        verify(mockCustomerRepository, times(1)).deleteById(1L);
	    }
	 @Test
	    void testGetAllCustomersInToronto() {
	        List<Customer> customers = new ArrayList<>();
	        customers.add(new Person("John Doe", new Address("123", "A1B 2C3", "Toronto", "ON"), new ArrayList<>()));

	        when(mockCustomerRepository.getAllCustomersInToronto()).thenReturn(customers);

	        List<Customer> foundCustomers = customerService.getAllCustomersInToronto();

	        assertNotNull(foundCustomers);
	        assertEquals(1, foundCustomers.size());
	        verify(mockCustomerRepository, times(1)).getAllCustomersInToronto();
	    }


}

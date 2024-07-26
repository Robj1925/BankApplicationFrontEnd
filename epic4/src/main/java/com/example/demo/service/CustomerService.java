package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.*;
import com.example.demo.model.Company;
import com.example.demo.model.Customer;
import com.example.demo.model.Person;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	public Customer createCustomer(CustomerDto customerDto) {
		Customer customer = null;
		if (customerDto.getCustomerType().equalsIgnoreCase("person")) {
			customer = new Person(customerDto.getName(), customerDto.getAddress(), new ArrayList<Account>());
			customer.getAddress().setCustomer(customer);
		} else if (customerDto.getCustomerType().equalsIgnoreCase("company")) {
			customer = new Company(customerDto.getName(), customerDto.getAddress(), new ArrayList<Account>());
			customer.getAddress().setCustomer(customer);
		}
		System.out.println(customer.getClass()); 
		return customerRepository.save(customer);
	}
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	public Customer findById(long id) throws CustomerNotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " does not exist!"));
	}
	 public Customer updateCustomer(long id, CustomerDto customerDto) throws CustomerNotFoundException {
	        Customer existingCustomer = findById(id);

	        existingCustomer.setName(customerDto.getName());
	        existingCustomer.getAddress().setStreetNumber(customerDto.getAddress().getStreetNumber());
	        existingCustomer.getAddress().setCity(customerDto.getAddress().getCity());
	        existingCustomer.getAddress().setProvidence(customerDto.getAddress().getProvidence());
	        existingCustomer.getAddress().setPostalCode(customerDto.getAddress().getPostalCode());
	        existingCustomer.getAddress().setCustomer(existingCustomer);

	        return customerRepository.save(existingCustomer);
	    }
	public void deleteById(long id) throws CustomerNotFoundException {
		findById(id);
		customerRepository.deleteById(id);
	}
	public List<Person> getAllPersons() {
		return customerRepository.getAllPersons();
	}
	public List<Company> getAllCompanies() {
		return customerRepository.getAllCompanies();
	}
	public List<Customer> getAllCustomersInToronto() {
		return customerRepository.getAllCustomersInToronto();
	}

}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import exception.CustomerNotFoundException;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	public Customer findById(long id) throws CustomerNotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " does not exist!"));
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public void deleteById(long id) throws CustomerNotFoundException {
		findById(id);
		customerRepository.deleteById(id);
	}

}

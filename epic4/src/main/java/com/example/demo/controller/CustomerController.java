package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@PostMapping("/customer")
	@Operation(summary="Creates new customer")
	@ApiResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}
	@GetMapping("/customers")
	@Operation(summary="Retrieve all customers")
	@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<List<Customer>> getAllEmployees() {
		return ResponseEntity.ok(customerService.findAllCustomers());
	}
	@GetMapping("/customer/{id}")
	@Operation(summary="Retrieve Customer by ID")
	@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
		return ResponseEntity.ok(customerService.findById(id));
	}
	@PutMapping("/customer")
	@Operation(summary="Update customer information")
	@ApiResponse(responseCode="200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.updateCustomer(customer));
	}
	@DeleteMapping("/customer/{id}")
	@Operation(summary="Delete customer by id")
	public ResponseEntity<Void> deleteCustomerbyId(@PathVariable long id) {
		customerService.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	
}

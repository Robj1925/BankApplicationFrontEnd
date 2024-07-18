package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.*;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@Operation(summary = "Retrieves all employees")
	@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.findAllEmployees());
	}

	@Operation(summary = "Sends a request to create an employee")
	@ApiResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee newEmployee) {
		Employee createdEmployee = employeeService.createEmployee(newEmployee);
		URI newResponseLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId()).toUri();
		return ResponseEntity.created(newResponseLocation).body(createdEmployee);
	}

	@Operation(summary = "Retrieves employee based on employee id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "302", description = "Employee found", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(mediaType = "application/json")) })
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Optional<Employee> retrievedEmployee = Optional.empty();
		try {
			retrievedEmployee = employeeService.findById(id);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		if (retrievedEmployee.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.FOUND).body(retrievedEmployee.get());
	}
	@Operation(summary = "Updates employee specified by employee id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = "application/json")) })
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @Valid @RequestBody Employee employee) {
		if (id != employee.getId()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee));
	}
	@Operation(summary = "Deletes employee specified by employee id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "EMPLOYEE NOT FOUND", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(mediaType = "application/json")) })
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
		Optional<Employee> retrievedEmployee = Optional.empty();
		try {
			retrievedEmployee = employeeService.findById(id);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		if (retrievedEmployee.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		employeeService.deleteEmployee(retrievedEmployee.get());
		return ResponseEntity.status(HttpStatus.GONE).body(retrievedEmployee.get());
	}

}

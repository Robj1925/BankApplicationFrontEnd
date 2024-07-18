package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.findAllEmployees());
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee) {
		Employee createdEmployee = employeeService.createEmployee(newEmployee);
		URI newResponseLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId()).toUri();
		return ResponseEntity.created(newResponseLocation).body(createdEmployee);
	}
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
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee) {
			if (id != employee.getId()) {
				return ResponseEntity.badRequest().build();
			}
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee));
	}
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

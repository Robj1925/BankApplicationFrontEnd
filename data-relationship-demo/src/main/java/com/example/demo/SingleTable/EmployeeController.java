package com.example.demo.SingleTable;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.ok(employeeService.createEmployee(employeeDTO));
	}
	@GetMapping("/junior-employees")
	public ResponseEntity<List<JuniorEmployee>> findAllJuniorEmployees() {
		return ResponseEntity.ok(employeeService.getAllJuniorEmployyes());
	}
}

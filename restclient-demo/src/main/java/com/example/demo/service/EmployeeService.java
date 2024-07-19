package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IEmployeeClient;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	private IEmployeeClient employeeClient;

	public EmployeeService(IEmployeeClient employeeClient) {
		super();
		this.employeeClient = employeeClient;
	}
	public List<Employee> getAllEmployees() {
		return employeeClient.getAllEmployees();
	}
	public void createEmployee(Employee employee) {
		employeeClient.createEmployee(employee);
	}
	public Optional<Employee> getEmployeeById(long id) {
		return employeeClient.getEmployeeById(id);
	}

	public Employee updateEmployee(long id, Employee employee) {
		return employeeClient.updateEmployee(id, employee);
	}

	public void deleteEmployee(long id) {
		employeeClient.deleteEmployee(id);
	}
	
}

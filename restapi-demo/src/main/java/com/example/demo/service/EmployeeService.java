package com.example.demo.service;
import com.example.demo.exception.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	public Optional<Employee> findById(Long id) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee does not exist!");
		}
		
		return employee;
	}
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	public void deleteEmployee(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	

}

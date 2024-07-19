package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface IEmployeeClient {
	 List<Employee> getAllEmployees();

	    Optional<Employee> getEmployeeById(long id);

	    Employee createEmployee(Employee newEmployee);

	    Employee updateEmployee(long id, Employee employee);

	    void deleteEmployee(long id);
	    
}

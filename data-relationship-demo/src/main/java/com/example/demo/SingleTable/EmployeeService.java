package com.example.demo.SingleTable;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	public Employee createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = null;
		if (employeeDTO.getEmployeeType().equalsIgnoreCase("junior")) {
			employee = new JuniorEmployee(employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getMentor());
		} else if (employeeDTO.getEmployeeType().equalsIgnoreCase("senior")) {
			employee = new SeniorEmployee(employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getMentee());
		}
		return employeeRepository.save(employee);
	}
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	public List<JuniorEmployee> getAllJuniorEmployyes() {
		return employeeRepository.findAllJuniorEmployees();
	}
}

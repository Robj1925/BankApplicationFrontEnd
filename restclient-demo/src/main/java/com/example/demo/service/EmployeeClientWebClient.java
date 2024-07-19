package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.demo.interfaces.IEmployeeClient;
import com.example.demo.model.Employee;

@Service
public class EmployeeClientWebClient implements IEmployeeClient {

	private WebClient employeeWebClient;

	public EmployeeClientWebClient(WebClient employeeWebClient) {
		super();
		this.employeeWebClient = employeeWebClient;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		employees = employeeWebClient.get().uri("/employees").retrieve().bodyToFlux(Employee.class).collectList()
				.block();

		return employees;
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		try {
			Employee employee = employeeWebClient.get().uri("/employee/" + id).retrieve().bodyToMono(Employee.class)
					.block();
			return Optional.ofNullable(employee);
		} catch (WebClientResponseException e) {
			System.err.println("Error fetching employee: " + e.getStatusCode());
			return Optional.empty();
		}
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeWebClient.post().uri("/employee").bodyValue(employee).retrieve().bodyToMono(Employee.class)
				.block();
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Employee updatedEmployee = null;
		updatedEmployee = employeeWebClient.put().uri("/employee/" + id).bodyValue(employee).retrieve().bodyToMono(Employee.class).block();
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
	    employeeWebClient.delete()
	        .uri("/employee/" + id)
	        .retrieve()
	        .toBodilessEntity()
	        .block();
	}
}

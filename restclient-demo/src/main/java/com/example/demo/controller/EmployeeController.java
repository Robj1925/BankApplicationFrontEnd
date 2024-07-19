package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;

	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/create-employee")
	public String createEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "create-employee";
	}
	@PostMapping("/create-employee")
	public String processCreateEmployee(Employee employee) {
		employeeService.createEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employee/{id}")
	public String findEmployeeById(@PathVariable long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		if (employee.isPresent()) {
			model.addAttribute("employee", employee.get());
			return "employee-details";  
		} else {
			
			return "redirect:/employees";  
		}
	}
	
	 @GetMapping("/update-employee/{id}")
	    public String showUpdateForm(@PathVariable long id, Model model) {
	        Optional<Employee> employee = employeeService.getEmployeeById(id);
	        if (employee.isPresent()) {
	            model.addAttribute("employee", employee.get());
	            return "update-employee"; 
	        } else {
	            return "redirect:/employees"; 
	        }
	    }

	    @PostMapping("/update-employee/{id}")
	    public String updateEmployee(@PathVariable long id, Employee employee, Model model) {
	        if (id != employee.getId()) {
	        }
	        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
	        if (updatedEmployee != null) {
	            model.addAttribute("employee", updatedEmployee);
	            return "redirect:/employees"; 
	        } else {
	            return "redirect:/employees"; 
	        }
	    }

	    @GetMapping("/delete-employee/{id}")
	    public String showDeleteConfirmation(@PathVariable long id, Model model) {
	        Optional<Employee> employee = employeeService.getEmployeeById(id);
	        if (employee.isPresent()) {
	            model.addAttribute("employee", employee.get());
	            return "delete-employee"; 
	        } else {
	            return "redirect:/employees"; 
	        }
	    }

	    @PostMapping("/delete-employee/{id}")
	    public String deleteEmployee(@PathVariable long id) {
	    	
	    	try {
		        employeeService.deleteEmployee(id);

	    	} catch(WebClientResponseException wb) {
	    		wb.printStackTrace();
		        return "redirect:/employees"; 

	    	}
	      //  employeeService.deleteEmployee(id);
	        return "redirect:/employees"; 
	    }

	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
		
	}


}

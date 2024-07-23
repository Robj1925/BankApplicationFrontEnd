package com.example.demo.SingleTable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT g FROM JuniorEmployee g")
	public List<JuniorEmployee> findAllJuniorEmployees();
	
	@Query("SELECT e FROM Employee e")
	public List<Employee> findAllEmployees();
}

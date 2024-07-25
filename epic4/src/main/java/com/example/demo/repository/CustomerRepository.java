package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Company;
import com.example.demo.model.Customer;
import com.example.demo.model.Person;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("SELECT s FROM Person s")
	public List<Person> getAllPersons();
	
	@Query("SELECT c FROM Company c")
	public List<Company> getAllCompanies();
	
}

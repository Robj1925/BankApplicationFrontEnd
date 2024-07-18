package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String department;
	@NotBlank
	@Pattern(regexp = "[0-9]+")
	@Size(min = 1, max = 3)
	private String age;
	public Employee() {
		super();
	}
	public Employee(String name, String department, String age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}

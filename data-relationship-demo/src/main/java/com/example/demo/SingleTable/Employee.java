package com.example.demo.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "FDMGROUP_EMPLOYEES")

public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String department;
	
	public Employee(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}
	public Employee() {
		super();
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
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	

}

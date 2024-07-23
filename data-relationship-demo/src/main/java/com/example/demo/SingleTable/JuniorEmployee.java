package com.example.demo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "JUNIOR_EMPLOYEES")
public class JuniorEmployee extends Employee {
	private String mentor;
	public JuniorEmployee() {
		super();
	}
	public JuniorEmployee(String name, String department) {
		super(name, department);
	}

	public JuniorEmployee(String name, String department, String mentor) {
		super(name, department);
		this.mentor = mentor;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	
}

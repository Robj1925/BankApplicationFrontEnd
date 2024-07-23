package com.example.demo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="SENIOR_EMPLOYEES")
public class SeniorEmployee extends Employee {
	private String mentee;

	public SeniorEmployee() {
		super();
	}
	public SeniorEmployee(String name, String department) {
		super(name, department);
	}

	public SeniorEmployee(String name, String department, String mentee) {
		super(name, department);
		this.mentee = mentee;
	}

	public String getMentee() {
		return mentee;
	}

	public void setMentee(String mentee) {
		this.mentee = mentee;
	}

	@Override
	public String toString() {
		return "SeniorEmployee [mentee=" + mentee + "]";
	}
	

}

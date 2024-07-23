package com.example.demo.SingleTable;

public class EmployeeDTO {
	private String name;
	private String department;
	private String employeeType;
	private String mentor;
	private String mentee;
	public EmployeeDTO(String name, String department, String employeeType, String mentor, String mentee) {
		super();
		this.name = name;
		this.department = department;
		this.employeeType = employeeType;
		this.mentor = mentor;
		this.mentee = mentee;
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
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	public String getMentee() {
		return mentee;
	}
	public void setMentee(String mentee) {
		this.mentee = mentee;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", department=" + department + ", employeeType=" + employeeType
				+ ", mentor=" + mentor + ", mentee=" + mentee + "]";
	}
	
	

}

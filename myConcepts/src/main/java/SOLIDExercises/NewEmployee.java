package SOLIDExercises;

import java.util.List;

public class NewEmployee implements NewEmployeeRepo {
	private int employeeId;
	private String employeeName;
	private double salary;
	private List<Employee> employees;
	
	public NewEmployee(int employeeId, String employeeName, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

}

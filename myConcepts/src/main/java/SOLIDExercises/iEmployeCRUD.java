package SOLIDExercises;

import java.util.List;

public interface iEmployeCRUD {
	public void addEmployee(Employee employee);
	public void removeEmployee(int employeeId);
	public void updateEmployee(Employee employee);
	public List<Employee> listEmployees();

}

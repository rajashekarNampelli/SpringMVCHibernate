package hibernate.service;

import java.util.List;

import hibernate.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public List<Employee> listEmployee();

	public Employee getEmployeeById(int id);

	public void removeEmployee(int id);
}

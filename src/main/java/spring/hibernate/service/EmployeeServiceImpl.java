package hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import hibernate.dao.EmployeeDAO;
import hibernate.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDao;

	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Transactional
	public void addEmployee(Employee emp) {
		this.employeeDao.addEmployee(emp);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		this.employeeDao.updateEmployee(emp);
	}

	@Transactional
	public List<Employee> listEmployee() {
		return this.employeeDao.listEmployee();
	}

	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDao.getEmployeeById(id);
	}

	@Transactional
	public void removeEmployee(int id) {
		this.employeeDao.removeEmployee(id);
	}

}

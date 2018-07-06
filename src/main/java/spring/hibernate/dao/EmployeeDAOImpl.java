package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hibernate.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(emp);
		logger.info("Employee saved successfully, Employee Details=" + emp);
	}

	public void updateEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(emp);
		logger.info("Employee updated successfully, Employee Details=" + emp);
	}

	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> EmployeesList = session.createQuery("from Employee").list();
		for (Employee emp : EmployeesList) {
			logger.info("Employee List::" + emp);
		}
		return EmployeesList;
	}

	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		logger.info("Employee loaded successfully, Employee details=" + emp);
		return emp;
	}

	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if (null != emp) {
			session.delete(emp);
		}
		logger.info("Employee deleted successfully, Employee details=" + emp);
	}
}

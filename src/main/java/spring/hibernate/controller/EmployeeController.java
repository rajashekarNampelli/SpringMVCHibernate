package hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hibernate.model.Employee;
import hibernate.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "EmployeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployee());
		return "employee";
	}

	// For add and update employee both
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") Employee emp) {
		if (emp.getEmployeeId() == 0) {
			// new employee, add it
			this.employeeService.addEmployee(emp);
			;
		} else {
			// existing employee, call update
			this.employeeService.updateEmployee(emp);
			;
		}
		return "redirect:/employees";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.employeeService.removeEmployee(id);
		return "redirect:/employees";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("listPersons", this.employeeService.listEmployee());
		return "employee";
	}

}

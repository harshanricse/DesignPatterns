package compositePattern;

import java.util.ArrayList;
import java.util.List;

//Component interface
interface Employee {
	void showDetails();
}

//Composite class representing a department
class Department implements Employee {
	private String name;
	private List<Employee> employees;

	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	@Override
	public void showDetails() {
		System.out.println("Department: " + name);
		for (Employee employee : employees) {
			employee.showDetails();
		}
	}
}

//Leaf class representing an individual employee
class EmployeeLeaf implements Employee {
	private String name;
	private String position;

	public EmployeeLeaf(String name, String position) {
		this.name = name;
		this.position = position;
	}

	@Override
	public void showDetails() {
		System.out.println("Employee: " + name + ", Position: " + position);
	}
}

public class Client {
	public static void main(String[] args) {
		// Create individual employees
		Employee emp1 = new EmployeeLeaf("John Doe", "Manager");
		Employee emp2 = new EmployeeLeaf("Jane Smith", "Developer");
		Employee emp3 = new EmployeeLeaf("Bob Johnson", "QA Engineer");

		// Create departments and add employees to them
		Department devDepartment = new Department("Development Department");
		devDepartment.addEmployee(emp2);
		devDepartment.addEmployee(emp3);

		Department company = new Department("Company");
		company.addEmployee(emp1);
		company.addEmployee(devDepartment);

		// Show the entire organizational structure
		company.showDetails();
	}
}
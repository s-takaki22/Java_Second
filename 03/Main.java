package logic;

import dao.EmployeeDAO;
import dto.Employee;

public class Main {

	public static void main(String[] args) {
		Employee emp = new Employee("12345", "takahashi", 20);
		Employee emp2 = new Employee("54321", "takada", 25);
		Employee emp3 = new Employee("99999", "hosokawa", 30);
		
		EmployeeDAO.registerEmployee(emp);
		EmployeeDAO.registerEmployee(emp2);
		EmployeeDAO.registerEmployee(emp3);
		
		EmployeeDAO.deleteEmployee("12345");
	}

}

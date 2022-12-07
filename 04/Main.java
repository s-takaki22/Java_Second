package logic;

import java.util.List;

import dao.EmployeeDAO;
import dto.Employee;

public class Main {

	public static void main(String[] args) {
//		Employee emp = new Employee("12345", "higuchi", 20);
//		Employee emp2 = new Employee("54321", "matsutaka", 25);
//		Employee emp3 = new Employee("99999", "yamaguchi", 30);
//		
//		EmployeeDAO.registerEmployee(emp);
//		EmployeeDAO.registerEmployee(emp2);
//		EmployeeDAO.registerEmployee(emp3);
		
//		EmployeeDAO.deleteEmployee("12345");

		// 1件取得するメソッドを実行
		Employee result = EmployeeDAO.selectEmployee("456");
		System.out.println(result.getEmployeeNumber());
		System.out.println(result.getName());
		System.out.println(result.getAge());
		
		System.out.println("----------------------------");
		
		// 全件取得するメソッドを実行
		List<Employee> list = EmployeeDAO.selectAllEmployee();
		for(Employee e : list) {
			System.out.println(e.getEmployeeNumber() + ":" + e.getName());
		}

		System.out.println("----------------------------");

		// 全件取得するメソッドを実行
		List<Employee> likeList = EmployeeDAO.searchEmployeeByName("ka");
		for(Employee e : likeList) {
			System.out.println(e.getEmployeeNumber() + ":" + e.getName());
		}

	}

}

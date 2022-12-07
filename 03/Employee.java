package dto;

public class Employee {
	private String employeeNumber;
	private String name;
	private int age;
	
	public Employee(String employeeNumber, String name, int age) {
		super();
		this.employeeNumber = employeeNumber;
		this.name = name;
		this.age = age;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

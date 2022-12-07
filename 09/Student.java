package dto;

public class Student {
	String name;
	int grade;
	String email;
	String gender;
	
	public Student(String name, int grade, String email, String gender) {
		super();
		this.name = name;
		this.grade = grade;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}

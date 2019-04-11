package br.com.activity.modelo;
import br.com.activity.modelo.class_Student;

public class class_schoolClass {
	private String Name;
	private String School;
	private class_Student[] Students;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getSchool() {
		return School;
	}
	
	public void setSchool(String School) {
		this.School = School;
	}
	
	public class_Student[] getStudents() {
		return Students;
	}
	
	public void setStudents(class_Student[] Students) {
		this.Students = Students;
	}
}

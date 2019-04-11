package br.com.activity.modelo;

public class class_Student {
	private double RGM;
	private String Name;
	private String className;
	private String School;
	private float[] Grades;
	private float finalGrade;
	
	public double getRGM() {
		return RGM;
	}
	
	public void setRGM(double RGM) {
		this.RGM = RGM;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getSchool() {
		return School;
	}
	
	public void setSchool(String School) {
		this.School = School;
	}
	
	public float[] getGrades() {
		return Grades;
	}
	
	public void setGrades(float[] Grades) {
		this.Grades = Grades;
	}
	
	public float getFinalGrade() {
		return finalGrade;
	}
	
	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}
}

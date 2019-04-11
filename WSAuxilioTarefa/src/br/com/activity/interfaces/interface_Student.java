package br.com.activity.interfaces;

public interface interface_Student {
	public boolean editStudent(String className, Double RGM, String Name, String School);
	public boolean alterGrade(String className, Double RGM, float[] Grades);
	public boolean alterFinalGrade(String className, Double RGM, float finalGrade);
	public boolean sendGrades();
}

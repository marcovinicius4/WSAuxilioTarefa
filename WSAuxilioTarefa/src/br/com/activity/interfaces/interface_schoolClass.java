package br.com.activity.interfaces;

import br.com.activity.modelo.class_Student;
import br.com.activity.modelo.class_schoolClass;


public interface interface_schoolClass {
	public void createClass(String Name, String School, int professorID) throws Exception;
	public void deleteClass(int classID) throws Exception;
	public class_schoolClass[] returnSchoolClasses(String School) throws Exception;
	public class_Student[] returnStudents(String School, String Class) throws Exception;
	public void addSudent(String className, Double RGM, String Name, String School) throws Exception;
	public void removeStudent(String className, double RGM) throws Exception;
}

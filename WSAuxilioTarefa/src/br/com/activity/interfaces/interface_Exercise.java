package br.com.activity.interfaces;

import org.apache.tomcat.jni.Socket;

public interface interface_Exercise {
	public boolean createExercise(String Name, String Text, int Answer, String Option1, String Option2, String Option3, String Option4);
	public boolean editExercise(String Name, String Text, int Answer, String Option1, String Option2, String Option3, String Option4);
	public boolean deleteExercise(String Name);
	public boolean distributeExercise(String Name, Socket[] Connections);
}

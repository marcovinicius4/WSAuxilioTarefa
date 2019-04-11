package br.com.activity.interfaces;

import br.com.activity.modelo.*;

public interface interface_Professor {
	public void createAccount(String Email, String Name, String Password) throws Exception;
	public void sendEmailConfirmation(String Email) throws Exception;
	public boolean checkEmailConfirmation(String Email) throws Exception;
	public class_Professor professorLogin(String Email, String Password) throws Exception;
	public void confirmEmail(String Email) throws Exception;
	public void connectWithStudents(int port) throws Exception;
}

package br.com.activity.controller;

import br.com.activity.dao.ProfessorDAO;
import br.com.activity.interfaces.*;
import br.com.activity.modelo.*;

public class ControleProfessor implements interface_Professor {
	private class_Professor professorReference = new class_Professor();

	@Override
	public void createAccount(String Email, String Name, String Password) throws Exception {
		if (Email != "" || Name != "" || Password != "") {
			professorReference.setEmail(Email);
			professorReference.setName(Name);
			professorReference.setPassword(Password);

			ProfessorDAO.dbCreateAccount(professorReference.getEmail(), professorReference.getPassword(),
					professorReference.getName());
		} else {
			throw new Exception("Email, Name or Password invalid");
		}
	}

	@Override
	public boolean checkEmailConfirmation(String Email) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public class_Professor professorLogin(String Email, String Password) throws Exception {
		// boolean Success = false;

		if (Email != "" || Password != "") {
			professorReference.setEmail(Email);
			professorReference.setPassword(Password);

			try {
				ProfessorDAO.dbCheckLogin(professorReference.getEmail(), professorReference.getPassword());

			} catch (Exception e) {
				System.out.println(e.toString());
				throw new Exception("professorLogin Exception");
			}
		}
		/*
		 * if(checkEmailConfirmation(Email)) { Success = true; } else {
		 * sendEmailConfirmation(Email); Success = false; throw new
		 * Exception("Email not Confimed"); }
		 * 
		 * System.out.println("Success");
		 * 
		 * 
		 * if (Success) { return professorReference; } else { return null; }
		 */
		return professorReference;

	}

	@Override
	public void confirmEmail(String Email) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectWithStudents(int port) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEmailConfirmation(String Email) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

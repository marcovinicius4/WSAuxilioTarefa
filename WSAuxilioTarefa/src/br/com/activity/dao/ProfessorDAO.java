package br.com.activity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.activity.util.*;
import br.com.activity.modelo.*;

public class ProfessorDAO {

	static Connection con = null;

	public void registerProfessor(String name, String email, String password) throws Exception { //Usar checkEmailExistence primeiro
		try {
			con = class_DBCon.Conectar();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO professor (name, email, password, status) VALUES (?, ?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setBoolean(4, true);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("registerProfessor Exception")
		}
		con.close();
	}
	
	public boolean checkEmailExistence(String email) throws Exception {
		boolean result = false; //Necessario para rodar o con.close() e depois sair da função
		
		try {
			con = class_DBCon.Conectar();
			PreparedStatement pstmt = con.prepareStatement("SELECT email FROM professor WHERE email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("checkEmailExistence Exception");
		}
		
		con.close();
		
		return result;
	}
	
	public void deleteProfessor(String email) throws Exception { //Usar checkEmailExistence primeiro
		try {
			con = class_DBCon.Conectar();
			PreparedStatement pstmt = con.prepareStatement("UPDATE professor SET status = ? WHERE email = ?");
			pstmt.setBoolean(1, false);
			pstmt.setString(2, email);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("deleteProfessor Exception");
		}
		con.close();
	}
	
	public class_Professor returnProfessor() throws Exception {
		try {
			con = class_DBCon.Conectar();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception ("returnProfessor Exception");
		}
	}
	
	//OLD
	public static boolean dbCheckEmailExistence(String Email) throws Exception {

		try {

			PreparedStatement pstmt = con.prepareStatement("SELECT email FROM professor WHERE email = ?");
			pstmt.setString(1, Email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("dbCheckEmail Exception");
		}
		con.close();

		return false;

	}

	public static void dbCreateAccount(String Email, String Password, String Name) throws Exception {

		try {

			if (!dbCheckEmailExistence(Email)) {
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO professor (email, password, name) VALUES (?, ?, ?)");
				pstmt.setString(1, Email);
				pstmt.setString(2, Password);
				pstmt.setString(3, Name);
				pstmt.execute();
			} else {
				throw new Exception("This Email is Already Registered");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("dbCreateAccount Exception");
		}
		con.close();
	}

	// nao entendi o trecho de codigo de confirmacao
	public boolean dbCheckEmailConfirmation(String Email) throws Exception {
		boolean confirmation = false;
		try {

			PreparedStatement pstmt = con
					.prepareStatement("SELECT idprofessor, confirmation FROM professor WHERE email = ?");
			pstmt.setString(1, Email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) >= 0) {
					confirmation = rs.getBoolean(2);
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("dbCheckEmailConfirmation Exception");
		}
		con.close();
		return confirmation;
	}

	public static class_Professor dbCheckLogin(String Email, String Password) throws Exception {
		boolean Success = false;
		class_Professor professorReference = new class_Professor();

		try {

			PreparedStatement pstmt = con
					.prepareStatement("SELECT idprofessor, email, name, password FROM professor WHERE email = ?");
			pstmt.setString(1, Email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) >= 0) {
					if (rs.getString(4).equals(Password)) {
						professorReference.setIDProfessor(rs.getInt(1));
						professorReference.setEmail(rs.getString(2));
						professorReference.setName(rs.getString(3));

						Success = true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("dbCheckLogin Exception");
		}
		con.close();

		if (Success) {
			return professorReference;
		} else {
			return null;
		}
	}

}

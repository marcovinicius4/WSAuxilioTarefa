package br.com.activity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.activity.util.*;
import br.com.activity.modelo.*;

public class ProfessorDAO {

	static Connection con = class_DBCon.Conectar();

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

	public boolean dbCreateClass(String School, String Name, int professorID) throws Exception {
		boolean Copy = false;

		try {
			PreparedStatement pstmt = con
					.prepareStatement("SELECT nome, idturma, idprofessor FROM turma WHERE instituicao = ?");
			pstmt.setString(1, School);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(Name) && rs.getInt(2) == professorID && rs.getInt(3) >= 0) {
					Copy = true;
				}
			}
			if (Copy) {
				pstmt = con.prepareStatement(
						"INSERT INTO turma (professor_idprofessor, nome, instituicao) VALUES (?, ?, ?)");
				pstmt.setInt(1, professorID);
				pstmt.setString(2, Name);
				pstmt.setString(3, School);
				pstmt.execute();
			} else {
				throw new Exception("Already Exists a Class of the same name for this Institution");
			}
		} catch (Exception e) {
			throw new Exception("dbCreateClass Exception");
		}

		return true;
	}

	public void dbDeleteClass(int classID) throws Exception { //melhor adicionar uma flag inativando classe
		boolean Exists = false;

		try {
			PreparedStatement pstmt = con
					.prepareStatement("SELECT idturma FROM turma where idturma = ?");
			pstmt.setInt(1, classID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Exists = true;
			}

			if (Exists) {
				pstmt = con.prepareStatement("UPDATE turma SET idturma = ? WHERE idturma = ?");
				pstmt.setInt(1, classID * -1);
				pstmt.setInt(2, classID);
			} else {
				throw new Exception("Class being deleted doesn't exists");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("dbDeleteClass Exception");
		}
	}

	public ArrayList<class_schoolClass> dbReturnClasses(String School, int professorID) throws Exception {
		ArrayList<class_schoolClass> classesReferences = new ArrayList<class_schoolClass>();


		try {
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM turma WHERE professor_idProfessor = ?");
			pstmt.setInt(1, professorID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("dbReturnClasses Exception");
		}

		return classesReferences;
	}

}

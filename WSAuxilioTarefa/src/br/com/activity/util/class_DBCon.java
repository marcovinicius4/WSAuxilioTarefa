package br.com.activity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//conexao com o banco Postgres
public class class_DBCon {

	public Statement stmt; 
	public ResultSet rs; 

	public static Connection Conectar() {

		Connection con = null;
		try {
			//driver que será utilizado
			Class.forName("org.postgresql.Driver");

			//cria um objeto de conexão com um BD especificado no caminho
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC", "postgres", "postgres");
		} catch (ClassNotFoundException erro1) {
			throw new RuntimeException(erro1);
		} catch (SQLException erro2) {
			throw new RuntimeException(erro2);
		}
		return con;
	}
}

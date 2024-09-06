package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/sabetodo_bd?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String SENHA = "Root@123";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	private static Connection connection;
	
	public static Connection conectar(){
		
		try { 
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, SENHA);
			return connection;
		} catch (ClassNotFoundException e1) {
			System.out.println("Erro aqui: " + e1.getMessage());
			System.out.println(e1.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
			
	public static void desconectar(){
		
		try{
			if(connection != null){
				connection.close();
				connection = null;
			}
		}
		
		catch(SQLException ex){
			System.out.println(ex.getMessage());
			
		}
		
	}
}
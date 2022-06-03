package br.com.agenda.factory;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionFactory {
	

	private static final String USERNAME = "root";
	
	
	private static final String PASSWORD = "87275346";
	
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	/*
	 * Conex�o com o banco de dados	
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		//Recuperar uma conex�o com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conex�o � nula
		if(con!=null) {
			System.out.println("ok!");
			con.close();
		}
	}
	

}

package br.com.genda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private static final String DATABASE_URL = "jsbc:mysql://localhoot:8080/agenda";
	
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.jdbc.driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
		
	}
	public static void main(String[] args) {
		Connection con = createConnectionToMySQL();
		
		if(con != null) {
			System.out.println("conexao ok");
			con.close();
		}
	}
}
package leo.labatut.projet.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	
	private static Connection connection;
	
	private SingleConnection(String url, String login, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection =DriverManager.getConnection(url, login,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getInstance(String url , String login, String password) {
		new SingleConnection(url,login,password);
		return connection;
	}
}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionController {

	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/users", "mzhang055", "Michelle09..");
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return con;
	
	}
}

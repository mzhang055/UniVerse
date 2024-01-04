/* Michelle Zhang
 * This class is responsible for managing database connections between this java application
 * and the MySQL database. It reutrns a Connection object which is a part of the JDBC API
 * Sources used: https://1bestcsharp.blogspot.com/2018/05/java-login-and-register-form-with-mysql-database.html
 * 
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionController {

	
	public static Connection getConnection() {
		//the connection object to be returned
		Connection con = null;
		
		try {
			//dynamically load the MySQL JDBC driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish a connection to the MySQL database
			con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");
			
			//handle errors
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		//return the connection object
		return con;
	
	}
}

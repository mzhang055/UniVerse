/* Michelle Zhang
 * 
 * Sources used: https://1bestcsharp.blogspot.com/2018/05/java-login-and-register-form-with-mysql-database.html
 * 
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionController {

	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return con;
	
	}
}

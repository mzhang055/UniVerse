package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.StudentData;


public class LoginController {

	
	
	//checks if a username already exists
	public static boolean checkUsername(String username) {
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUser = false;
		
		String query = "SELECT * FROM `app_users` WHERE `username` =?";
		
		try {
			ps = ConnectionController.getConnection().prepareStatement(query);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				checkUser = true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkUser;


	}
	
	//add user to the mysql database
	public static void addUserToDatabase(StudentData studentData) {
		
		PreparedStatement ps;
		String query = "INSERT INTO `app_users`(`firstName`, `lastName`, `unit`, `address`, `city`, `postalCode`, `province`, `country`, `longitude`, `latitude`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = ConnectionController.getConnection().prepareStatement(query);

			ps.setString(1, studentData.getFirstName());
			ps.setString(2, studentData.getLastName());
			ps.setString(3, studentData.getUnit());
			ps.setString(4, studentData.getAddress());
			ps.setString(5, studentData.getCity());
			ps.setString(6, studentData.getPostalCode());
			ps.setString(7, studentData.getProvince());
			ps.setString(8, studentData.getCountry());
			ps.setString(9, studentData.getLongitude());
			ps.setString(10, studentData.getLatitude());
			ps.setString(11, studentData.getUsername());
			ps.setString(12, studentData.getPassword());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "New User Added");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

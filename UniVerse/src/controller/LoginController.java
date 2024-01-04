/* Michelle Zhang
 * This class is responsible for handling user authentication, database operations related to user data,
 * and updating user information in the MySQL database.
 */

package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.StudentData;
import view.HomeFrame;
import view.SurveyResultPanel;
import view.UserSetUpFrame;
import view.WelcomeFrame;

public class LoginController {
	private static UserSetUpFrame setUpFrame;

	// checks if a username already exists
	public static boolean checkUsername(String username) {
		PreparedStatement ps; //for executing SQL queries
		ResultSet rs; //for storing query results
		boolean checkUser = false; //boolean to indicate if a user exists of not

		//SQL query to check if the username exists in the database called app_users
		String query = "SELECT * FROM `app_users` WHERE `username` =?";

		try {
			// create a prepared statement and set the username parameter
			ps = ConnectionController.getConnection().prepareStatement(query);
			ps.setString(1, username);

			//execute to check if the result set has any entries
			rs = ps.executeQuery();

			//if there are entries, the username exists
			if (rs.next()) {
				checkUser = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkUser;

	}

	// add user to the mysql database
	public static void addUserToDatabase(StudentData studentData) {

		PreparedStatement ps; //for execution
		
		//this string inserts a new user into the database
		String query = "INSERT INTO `app_users`(`firstName`, `lastName`, `unit`, `address`, `city`, `postalCode`, "
				+ "`province`, `country`, `longitude`, `latitude`, `username`, `password`, `course1`, `grade1`, "
				+ "`course2`, `grade2`, `course3`, `grade3`, `course4`, `grade4`, `course5`, `grade5`, `course6`, "
				+ "`grade6`, `course7`, `grade7`, `course8`, `grade8`, `choice1`, `choice2`, `choice3`, `bookmark1`, "
				+ "`bookmark2`, `bookmark3`, `bookmark4`, `bookmark5`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		//set the user data in database with the data the user entered
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
			ps.setString(13, studentData.getCourse1());
			ps.setString(14, studentData.getGrade1());
			ps.setString(15, studentData.getCourse2());
			ps.setString(16, studentData.getGrade2());
			ps.setString(17, studentData.getCourse3());
			ps.setString(18, studentData.getGrade3());
			ps.setString(19, studentData.getCourse4());
			ps.setString(20, studentData.getGrade4());
			ps.setString(21, studentData.getCourse5());
			ps.setString(22, studentData.getGrade5());
			ps.setString(23, studentData.getCourse6());
			ps.setString(24, studentData.getGrade6());
			ps.setString(25, studentData.getCourse7());
			ps.setString(26, studentData.getGrade7());
			ps.setString(27, studentData.getCourse8());
			ps.setString(28, studentData.getGrade8());

			// the next few columns (29 to 31) are set null because they store the user's 3
			// survey results
			// these values are updated in the method below once the user completes the
			// survey
			ps.setString(29, null);
			ps.setString(30, null);
			ps.setString(31, null);
			
			
			//next 5 columns are also set null becuase they are for the user's bookmarks. this 
			//is updated in the later methods once the user has bookmarked something
			ps.setString(32, null);
			ps.setString(33, null);
			ps.setString(34, null);
			ps.setString(35, null);
			ps.setString(36, null);
		

			//if execution of query is successful, display message to user
			if (ps.executeUpdate() > 0) {
			    // Display a success message
			    JOptionPane.showMessageDialog(null, "New User Added");

			    // create a new instance of UserSetUpFrame
			    setUpFrame = new UserSetUpFrame();

			    //dispose set up frame
			    SwingUtilities.invokeLater(() -> {
			        if (setUpFrame != null) {
			            setUpFrame.dispose();
			        }
			    });
			}


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	//get user data from database using the username
	public static StudentData getUserData(String username) {
		PreparedStatement ps; //execution
		ResultSet rs; //storing

		
		//query to select user data based on the username
		String query = "SELECT * FROM `app_users` WHERE `username` =?";

		try {
			//set and execute the query
			ps = ConnectionController.getConnection().prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			//if the result set has a least one row, create a StudentData object and
			//set its properties
			if (rs.next()) {
				StudentData studentData = new StudentData();
				studentData.setFirstName(rs.getString("firstName"));
				studentData.setLastName(rs.getString("lastName"));
				studentData.setUnit(rs.getString("unit"));
				studentData.setAddress(rs.getString("address"));
				studentData.setCity(rs.getString("city"));
				studentData.setPostalCode(rs.getString("postalCode"));
				studentData.setProvince(rs.getString("province"));
				studentData.setCountry(rs.getString("country"));
				studentData.setLongitude(rs.getString("longitude"));
				studentData.setLatitude(rs.getString("latitude"));
				studentData.setUsername(rs.getString("username"));
				studentData.setPassword(rs.getString("password"));
				studentData.setCourse1(rs.getString("course1"));
				studentData.setGrade1(rs.getString("grade1"));
				studentData.setCourse2(rs.getString("course2"));
				studentData.setGrade2(rs.getString("grade2"));
				studentData.setCourse3(rs.getString("course3"));
				studentData.setGrade3(rs.getString("grade3"));
				studentData.setCourse4(rs.getString("course4"));
				studentData.setGrade4(rs.getString("grade4"));
				studentData.setCourse5(rs.getString("course5"));
				studentData.setGrade5(rs.getString("grade5"));
				studentData.setCourse6(rs.getString("course6"));
				studentData.setGrade6(rs.getString("grade6"));
				studentData.setCourse7(rs.getString("course7"));
				studentData.setGrade7(rs.getString("grade7"));
				studentData.setCourse8(rs.getString("course8"));
				studentData.setGrade8(rs.getString("grade8"));
				studentData.setChoice1(rs.getString("choice1"));
				studentData.setChoice2(rs.getString("choice2"));
				studentData.setChoice3(rs.getString("choice3"));
				studentData.setBookmark1(rs.getString("bookmark1"));
				studentData.setBookmark2(rs.getString("bookmark2"));
				studentData.setBookmark3(rs.getString("bookmark3"));
				studentData.setBookmark4(rs.getString("bookmark4"));
				studentData.setBookmark5(rs.getString("bookmark5"));

				return studentData;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//reutrn null if no user data is found
		return null;
	}

	// this method checks if the user already exists in the database
	public static boolean doesUserExist(String username) {
		//execute and store query
		PreparedStatement ps;
		ResultSet rs;

		//query to select user data based on username
		String query = "SELECT * FROM `app_users` WHERE `username` =?";

		//check if the user exists
		try {
			ps = ConnectionController.getConnection().prepareStatement(query);
			ps.setString(1, username);

			rs = ps.executeQuery();

			// if this is true, user exists. if not, they dont exist
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//reutrn false is no user found
		return false;
	}

	// update user survey choices in the mysql database
	public static void updateSurveyChoices(String username, String choice1, String choice2, String choice3) {
		PreparedStatement ps; //execute the sql query
		
		//udpate user survey choices based on the username. this helps find the row to update
		String query = "UPDATE `app_users` SET `choice1`=?, `choice2`=?, `choice3`=? WHERE `username`=?";

		try {
			ps = ConnectionController.getConnection().prepareStatement(query);
			
			//set values for the parameters in teh sql query
			ps.setString(1, choice1);
			ps.setString(2, choice2);
			ps.setString(3, choice3);
			ps.setString(4, username);

			//if update is successful, display updated message
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Survey Choices Updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// update user bookmarks in the map in the mysql database
	public static void updateBookmarks(String username, int bookmark1, int bookmark2, int bookmark3, int bookmark4, int bookmark5) {
		PreparedStatement ps;
		String query = "UPDATE `app_users` SET `bookmark1`=?, `bookmark2`=?, `bookmark3`=?, `bookmark4`=?, `bookmark5`=? WHERE `username`=?";

		try {
			ps = ConnectionController.getConnection().prepareStatement(query);
			//set values for the needed parameters
			ps.setInt(1, bookmark1);
			ps.setInt(2, bookmark2);
			ps.setInt(3, bookmark3);
			ps.setInt(4, bookmark4);
			ps.setInt(5, bookmark5);
			ps.setString(6, username);

			//if the update was sucessful, dipslay a message to user
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Bookmark Choices Updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//reset the user's password in the mysql database
	public static void updatePassword(String username, String password) { 
		PreparedStatement ps;
		//update password based on the username
		String query = "UPDATE `app_users` SET `password`=? WHERE `username`=?";

		try {
			//get the prepared statement
			ps = ConnectionController.getConnection().prepareStatement(query);
			
			//seet values for the parameters
			ps.setString(1, password);
			ps.setString(2, username);

			//if update is sucessful, display message to user
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Password Sucessfully Reset");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

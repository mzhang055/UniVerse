/* Michelle Zhang
 *  * This class is responsible for prompting the user to enter their personal, 
 *  academic, and user info (username and password) during the registration process. 
 *  It collects the data and stores them into their respective arraylists and sets the student model
 * Sources used: https://1bestcsharp.blogspot.com/2018/05/java-login-and-register-form-with-mysql-database.html
 */

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.LoginController;
import model.StudentData;

public class UserSetUpFrame extends JFrame implements ActionListener {

	//fields for all componenets on the frame
	private JButton backBtn;
	private JButton questionBtn;
	
	// personal information
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField unitField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField postalCodeField;
	private JTextField provinceField;
	private JTextField countryField;
	private JTextField longitudeField;
	private JTextField latitudeField;

	// fields for user data
	public JTextField usernameField;
	private JTextField passwordField;

	// fields for user academic information
	private JTextField numCoursesField;
	private JButton confirmBtn;
	private JButton getStartedBtn;
	private JLayeredPane layeredPane;
	private JTextField courseCodeField;
	private JTextField gradeField;
	private JTextField lastGradeField; // used to track last grade field to add button dynamically

	//user fields to store data
	private String firstName;
	private String lastName;
	private String unit;
	private String address;
	private String city;
	private String postalCode;
	private String province;
	private String country;
	private String longitude;
	private String latitude;
	public static String username;
	private String password;

	// instance of classes
	public static StudentData studentData;
	public static HomeFrame homeFrame;
	
	

	// constructor
	public UserSetUpFrame() {
		super("User Set Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 900);

		// set the background image
		ImageIcon backgroundImg = new ImageIcon("images/userProfileSetupBg.png");
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight()));

		JLabel imageLabel = new JLabel(backgroundImg);
		imageLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		Dimension imageSize = new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		imageLabel.setPreferredSize(imageSize);

		// set the background colour for all text fields.
		Color color = new Color(245, 245, 245);
		
		//add a back button
		ImageIcon backIcon = new ImageIcon("images/backBtn.png");
		backBtn = new JButton(backIcon);
		backBtn.setOpaque(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setBorderPainted(false);
		backBtn.setBounds(20, 20, backIcon.getIconWidth(), backIcon.getIconHeight());
		backBtn.addActionListener(this);


		// --- Personal Info
		// add first name text field
		firstNameField = new JTextField(); // instantiate the JTextField
		firstNameField.setBounds(100, 300, 500, 80);
		firstNameField.addActionListener(this);
		firstNameField.setBackground(color);
		firstNameField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add last name text field
		lastNameField = new JTextField(); // instantiate the JTextField
		lastNameField.setBounds(745, 300, 500, 80);
		lastNameField.addActionListener(this);
		lastNameField.setBackground(color);
		lastNameField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add unit text field
		unitField = new JTextField(); // instantiate the JTextField
		unitField.setBounds(100, 450, 500, 80);
		unitField.addActionListener(this);
		unitField.setBackground(color);
		unitField.setFont(new Font("Arial", Font.PLAIN, 23));
		unit = unitField.getText();

		// add address field
		addressField = new JTextField(); // instantiate the JTextField
		addressField.setBounds(745, 450, 500, 80);
		addressField.addActionListener(this);
		addressField.setBackground(color);
		addressField.setFont(new Font("Arial", Font.PLAIN, 23));
		address = addressField.getText();

		// add city field
		cityField = new JTextField(); // instantiate the JTextField
		cityField.setBounds(100, 570, 500, 80);
		cityField.addActionListener(this);
		cityField.setBackground(color);
		cityField.setFont(new Font("Arial", Font.PLAIN, 23));
		city = cityField.getText();

		// add postal code field
		postalCodeField = new JTextField(); // instantiate the JTextField
		postalCodeField.setBounds(745, 570, 500, 80);
		postalCodeField.addActionListener(this);
		postalCodeField.setBackground(color);
		postalCodeField.setFont(new Font("Arial", Font.PLAIN, 23));
		postalCode = postalCodeField.getText();

		// add province field
		provinceField = new JTextField(); // instantiate the JTextField
		provinceField.setBounds(100, 700, 500, 80);
		provinceField.addActionListener(this);
		provinceField.setBackground(color);
		provinceField.setFont(new Font("Arial", Font.PLAIN, 23));
		province = provinceField.getText();

		// add country field
		countryField = new JTextField(); // instantiate the JTextField
		countryField.setBounds(745, 700, 500, 80);
		countryField.addActionListener(this);
		countryField.setBackground(color);
		countryField.setFont(new Font("Arial", Font.PLAIN, 23));
		country = countryField.getText();

		// add longitude field
		longitudeField = new JTextField(); // instantiate the JTextField
		longitudeField.setBounds(100, 830, 500, 80);
		longitudeField.addActionListener(this);
		longitudeField.setBackground(color);
		longitudeField.setFont(new Font("Arial", Font.PLAIN, 23));
		longitude = longitudeField.getText();

		// add latitude field
		latitudeField = new JTextField(); // instantiate the JTextField
		latitudeField.setBounds(745, 830, 500, 80);
		latitudeField.addActionListener(this);
		latitudeField.setBackground(color);
		latitudeField.setFont(new Font("Arial", Font.PLAIN, 23));
		latitude = latitudeField.getText();

		// ---- User Info (username and password)
		// add username field
		usernameField = new JTextField(); // instantiate the JTextField
		usernameField.setBounds(100, 1100, 500, 80);
		usernameField.addActionListener(this);
		usernameField.setBackground(color);
		usernameField.setFont(new Font("Arial", Font.PLAIN, 23));
		username = usernameField.getText();


		// add password field
		passwordField = new JTextField(); // instantiate the JTextField
		passwordField.setBounds(745, 1100, 500, 80);
		passwordField.addActionListener(this);
		passwordField.setBackground(color);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 23));
		password = passwordField.getText();

		// --- Academic Info
		numCoursesField = new JTextField();
		numCoursesField.setBounds(100, 1420, 200, 80);
		numCoursesField.addActionListener(this);
		numCoursesField.setBackground(color);
		numCoursesField.setFont(new Font("Arial", Font.PLAIN, 23));

		ImageIcon confirmIcon = new ImageIcon("images/confirmBtn.png");
		confirmBtn = new JButton(confirmIcon);
		confirmBtn.setOpaque(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setBounds(320, 1430, confirmIcon.getIconWidth(), confirmIcon.getIconHeight());
		confirmBtn.addActionListener(this);
		
		// add the question button which leads to a browser link to help get longitude and latitude
		ImageIcon questionIcon = new ImageIcon("images/questionBtn.png");
		questionBtn = new JButton(questionIcon);
		questionBtn.setOpaque(false);
		questionBtn.setContentAreaFilled(false);
		questionBtn.setBorderPainted(false);
		questionBtn.setBounds(1300, 830, questionIcon.getIconWidth(), questionIcon.getIconHeight());
		questionBtn.addActionListener(this);
		layeredPane.add(questionBtn, Integer.valueOf(5));
		
	
		// add components to the layered pane
		layeredPane.add(imageLabel, Integer.valueOf(0));
		layeredPane.add(firstNameField, Integer.valueOf(1));
		layeredPane.add(lastNameField, Integer.valueOf(1));
		layeredPane.add(unitField, Integer.valueOf(1));
		layeredPane.add(addressField, Integer.valueOf(1));
		layeredPane.add(cityField, Integer.valueOf(1));
		layeredPane.add(postalCodeField, Integer.valueOf(1));
		layeredPane.add(provinceField, Integer.valueOf(1));
		layeredPane.add(countryField, Integer.valueOf(1));
		layeredPane.add(longitudeField, Integer.valueOf(1));
		layeredPane.add(latitudeField, Integer.valueOf(1));
		layeredPane.add(numCoursesField, Integer.valueOf(1));
		layeredPane.add(confirmBtn, Integer.valueOf(1));
		layeredPane.add(backBtn, Integer.valueOf(1));

		// add user info to layered pane
		layeredPane.add(usernameField, Integer.valueOf(3));
		layeredPane.add(passwordField, Integer.valueOf(3));

		// add layered pane to scroll pane
		JScrollPane jsp = new JScrollPane(layeredPane);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.getVerticalScrollBar().setUnitIncrement(12);

		// add the scroll pane to the content pane
		getContentPane().add(jsp);

		// set frame visible
		setVisible(true);

	}
	
	// this method handles links to open webpages on browsers
	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//create arraylists to store course data and personal info
	public static List<StudentData> courseDataList = new ArrayList<>();
	public static List<StudentData> personalInfoList = new ArrayList<>();
	
	//this method collects the students course data
	private void collectCourseData() {
		//create a new instance of student data
	    studentData = new StudentData();
	    //set course fields to null by default
	    JTextField courseCodeField = null;

	    
	    //iterate through all components in the second layer
	    //only the course text fields are in the second later
	    for (Component component : layeredPane.getComponentsInLayer(Integer.valueOf(2))) {
	        if (component instanceof JTextField) {
	            JTextField textField = (JTextField) component;
	            String text = textField.getText().trim();

	            //however, if it is empty, set the respective course code field to null for both grade and course
	            if (!text.isEmpty()) {
	                
	                if (courseCodeField == null) {
	                    studentData.setCourseCode(text);
	                    courseCodeField = textField;
	                } else {
	                    studentData.setGrade(text);
	                    courseDataList.add(studentData);

	                    courseCodeField = null;
	                    studentData = new StudentData();
	                }
	            }
	        }
	    }



	    //iterate thorugh course data list to set the data for course and grade pairs 1 to 8
	    for (int i = 0; i < courseDataList.size(); i++) {
	        StudentData data = courseDataList.get(i);

	        switch (i) {
	            case 0:
	                studentData.setCourse1(data.getCourseCode());
	                studentData.setGrade1(data.getGrade());
	                break;
	            case 1:
	                studentData.setCourse2(data.getCourseCode());
	                studentData.setGrade2(data.getGrade());
	                break;
	            case 2:
	                studentData.setCourse3(data.getCourseCode());
	                studentData.setGrade3(data.getGrade());
	                break;
	            case 3:
	                studentData.setCourse4(data.getCourseCode());
	                studentData.setGrade4(data.getGrade());
	                break;
	            case 4:
	                studentData.setCourse5(data.getCourseCode());
	                studentData.setGrade5(data.getGrade());
	                break;
	            case 5:
	                studentData.setCourse6(data.getCourseCode());
	                studentData.setGrade6(data.getGrade());
	                break;
	            case 6:
	                studentData.setCourse7(data.getCourseCode());
	                studentData.setGrade7(data.getGrade());
	                break;
	            case 7:
	                studentData.setCourse8(data.getCourseCode());
	                studentData.setGrade8(data.getGrade());
	                break;
	        }
	    }

	}

	//this method collects and stores the user's personal data and adds it to the arraylist
	private void collectPersonalData() {

		studentData.setUsername(usernameField.getText());
		studentData.setPassword(passwordField.getText());
		studentData.setFirstName(firstNameField.getText());
		studentData.setLastName(lastNameField.getText());
		studentData.setUnit(unitField.getText());
		studentData.setAddress(addressField.getText());
		studentData.setCity(cityField.getText());
		studentData.setPostalCode(postalCodeField.getText());
		studentData.setProvince(provinceField.getText());
		studentData.setCountry(countryField.getText());
		studentData.setLongitude(longitudeField.getText());
		studentData.setLatitude(latitudeField.getText());

		personalInfoList.add(studentData);

	
	}

	//hanldes all users actions
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//when the conformed button is clicked, the program will validate the number of U/M the 
		//user entered. minimum 1, maximum 8
		if (e.getSource() == confirmBtn) {
		    try {
		        int numCourses = Integer.parseInt(numCoursesField.getText().trim());
		        if (numCourses > 0 && numCourses <= 8) {
		            // validate length of password
		        	
		        	//check if the user's password is strong enough
		            String password = passwordField.getText().trim();
		            if (password.length() < 8) {
		            	//let user know that their password isnt long enough 
		                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.");
		                return; 
		            }

		            createCourseFields(numCourses);
		        } else {
		            JOptionPane.showMessageDialog(this, "Please enter a valid number between 1 and 8.");
		        }
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this, "Please enter a valid number.");
		    }
		}


		// when user clicks the get started button, they finish their registration process
		//this also validates their username, password, and if a username already exists in the database
		else if (e.getSource() == getStartedBtn) {

			//collect all data
			collectCourseData();
			collectPersonalData();
			
			//validate users input and display messages if theres a concern
			if (studentData.getUsername().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter a valid username. It cannot be blank.");
			}

			else if (studentData.getPassword().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter a valid password. It cannot be blank.");
			}

			else if (LoginController.checkUsername(studentData.getUsername())) {
				JOptionPane.showMessageDialog(null, "This username already exists.");
			}

			//if the user's login data is valid, add them to the database
			else {
				LoginController.addUserToDatabase(studentData);
				
			    SwingUtilities.invokeLater(() -> {
			    	//new HomeFrame(studentData.getFirstName());
					
					homeFrame = new HomeFrame(studentData.getFirstName(), studentData.getChoice1()
							, studentData.getChoice2(), studentData.getChoice3());
					dispose();
			    });
			}


		}
		
		//returns back to the welcome frame
		else if (e.getSource() == backBtn) {
			new WelcomeFrame();
			dispose();
			
		}
		
		//opens a website that opens get long and lat
		else if (e.getSource() == questionBtn) {
			openWebpage("https://www.latlong.net/");
		}
	}
	
	
	//create course fields dynamically, depending on the number of courses the user took
	private void createCourseFields(int numCourses) {

		// add text fields for course code and grade dynamically
		for (int i = 0; i < numCourses; i++) {
			courseCodeField = new JTextField();
			gradeField = new JTextField();

			//set spacing
			int xCoordinate = 100;
			int yCoordinate = 1550 + i * 100; // create even spacing

			//create and set labels for the course info
			JLabel courseCodeLabel = new JLabel("Course Code:");
			courseCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			courseCodeLabel.setBounds(xCoordinate, yCoordinate, 250, 50);
			layeredPane.add(courseCodeLabel, Integer.valueOf(2));
			courseCodeField.setBounds(xCoordinate + 150, yCoordinate, 200, 50);
			layeredPane.add(courseCodeField, Integer.valueOf(2));

			//create and set grade info
			JLabel gradeLabel = new JLabel("Grade:");
			gradeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			gradeLabel.setBounds(xCoordinate + 350, yCoordinate, 250, 50);
			layeredPane.add(gradeLabel, Integer.valueOf(2));
			gradeField.setBounds(xCoordinate + 500, yCoordinate, 200, 50);
			layeredPane.add(gradeField, Integer.valueOf(2));

			//keep track of last grade field because we will be placing our 'get started' button right under it
			lastGradeField = gradeField;
		}
		// place 'get strated' button below the last text field
		if (lastGradeField != null) {
			int buttonYCoordinate = lastGradeField.getY() + lastGradeField.getHeight() + 15; // 15 is the spacing
			//create and set up button with iamge
			ImageIcon getStartedIcon = new ImageIcon("images/getStartedBtn.png");
			getStartedBtn = new JButton(getStartedIcon);
			getStartedBtn.setOpaque(false);
			getStartedBtn.setContentAreaFilled(false);
			getStartedBtn.setBorderPainted(false);
			getStartedBtn.setBounds(320, buttonYCoordinate, getStartedIcon.getIconWidth(),
					getStartedIcon.getIconHeight());
			getStartedBtn.addActionListener(this);
			layeredPane.add(getStartedBtn, Integer.valueOf(1));
		}

		// repaint the frame
		revalidate();
		repaint();
	}

	//getters and setters
	public static List<StudentData> getCourseDataList() {
		return courseDataList;
	}

	public static void setCourseDataList(List<StudentData> courseDataList) {
		UserSetUpFrame.courseDataList = courseDataList;
	}

	public static List<StudentData> getPersonalInfoList() {
		return personalInfoList;
	}

	public static void setPersonalInfoList(List<StudentData> personalInfoList) {
		UserSetUpFrame.personalInfoList = personalInfoList;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		UserSetUpFrame.username = username;
	}

	


}

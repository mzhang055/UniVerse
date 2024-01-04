/* Michelle Zhang
 * 
 * This class is responsible for displaying the user's profile frame 
 * where they can view their grades, sign out, or reset their password
 * 
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.LoginController;
import controller.MapController;
import model.StudentData;

public class StudentProfileFrame extends JFrame implements ActionListener {

	// fields
	private JButton signoutBtn;
	private JButton resetBtn;
	public static double totalPercent;
	public static double totalCourses;
	public static double overallAverage;

	// constructor
	public StudentProfileFrame(String course1, String grade1, String course2, String grade2, String course3,
			String grade3, String course4, String grade4, String course5, String grade5, String course6, String grade6,
			String course7, String grade7, String course8, String grade8) {
		// setup the frame
		super("Home Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 900);

		// set the background image
		ImageIcon backgroundImg = new ImageIcon("images/defaultBg.png");
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight()));

		JLabel imageLabel = new JLabel(backgroundImg);
		imageLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		Dimension imageSize = new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		imageLabel.setPreferredSize(imageSize);

		// add the navigation panel
		NavigationBarPanel navBarPanel = new NavigationBarPanel();
		navBarPanel.setBounds(0, 0, 1440, 90);
		layeredPane.add(navBarPanel, Integer.valueOf(1));

		// display the user's grades
		String[] courses = { course1, course2, course3, course4, course5, course6, course7, course8 };
		String[] grades = { grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 };

		// calculate number of rows needed to display course pairs
		// this rounds the float-point value to the nearest integer
		int rows = (int) Math.ceil((double) courses.length / 3);

		// use grid layout to displya grades
		GridLayout gridLayout = new GridLayout(rows, 3, 15, 10);

		// add to grades panel
		JPanel gradesPanel = new JPanel(gridLayout);
		gradesPanel.setOpaque(false);

		// count the total pairs of course and grades
		int totalPairs = courses.length;

		// display the labels for each course grade pair
		for (int i = 0; i < totalPairs; i++) {
			// check if the grade is not null and not empty to avoid
			// display null percentages
			if (grades[i] != null && !grades[i].isEmpty()) {
				JLabel courseLabel = new JLabel(courses[i]);
				JLabel gradeLabel = new JLabel(grades[i] + "%");

				// set styling
				courseLabel.setForeground(Color.decode("#587494"));
				courseLabel.setFont(new Font("Arial", Font.BOLD, 25));

				gradeLabel.setForeground(Color.decode("#587494"));
				gradeLabel.setFont(new Font("Arial", Font.BOLD, 25));

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = i % 2; // column index
				gbc.gridy = i / 2; // row index
				gbc.insets = new Insets(15, 15, 15, 15); // add spacing

				gradesPanel.add(courseLabel, gbc);

				gbc.gridx = (i % 2) + 1; // next column for grade label
				gradesPanel.add(gradeLabel, gbc);
			}
		}

		// calculate Y position based on the number of rows
		int yPosition = (rows - 1) * 50; // each course and grade pair take 50 pixels

		// display on frame
		gradesPanel.setBounds(30, yPosition, 800, rows * 110);
		layeredPane.add(gradesPanel, Integer.valueOf(1));

		// add the get signout button
		ImageIcon signoutIcon = new ImageIcon("images/signoutBtn.png");
		signoutBtn = new JButton(signoutIcon);
		signoutBtn.setOpaque(false);
		signoutBtn.setContentAreaFilled(false);
		signoutBtn.setBorderPainted(false);
		signoutBtn.setBounds(1000, 500, signoutIcon.getIconWidth(), signoutIcon.getIconHeight());
		signoutBtn.addActionListener(this);

		// add the get reset password button
		ImageIcon resetIcon = new ImageIcon("images/resetPasswordBtn.png");
		resetBtn = new JButton(resetIcon);
		resetBtn.setOpaque(false);
		resetBtn.setContentAreaFilled(false);
		resetBtn.setBorderPainted(false);
		resetBtn.setBounds(1000, 300, resetIcon.getIconWidth(), resetIcon.getIconHeight());
		resetBtn.addActionListener(this);

		// add background image to the last layer
		layeredPane.add(imageLabel, Integer.valueOf(0));
		layeredPane.add(signoutBtn, Integer.valueOf(1));
		layeredPane.add(resetBtn, Integer.valueOf(1));

		getContentPane().add(layeredPane);

		// set visible
		setVisible(true);

		// iterate through the courses and grades
		for (int i = 0; i < courses.length; i++) {
			// if there are values in the array, get the double value of the string
			if (grades[i] != null && !grades[i].isEmpty()) {
				try {
					double numericGrade = Double.parseDouble(grades[i]);
					// update counters
					totalPercent += numericGrade;
					totalCourses++;

					// handle errors
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Invalid grade: " + grades[i]);
				}
			}
		}

	}

	// this handles all user actions
	@Override
	public void actionPerformed(ActionEvent e) {

		// if user clicks on the signout button
		if (e.getSource() == signoutBtn) {

			SwingUtilities.invokeLater(() -> {
				String username = WelcomeFrame.getDataUsername();

				// check if user exists in the data base
				if (LoginController.doesUserExist(username)) {
					StudentData userData = LoginController.getUserData(username);

					// user exists in the database so get data
					if (userData != null) {
						MapController.updateBookmarks(userData.getUsername());
						SurveyResultPanel.updateSurveyChoices(userData.getUsername());

						// handle errors
					} else {
						JOptionPane.showMessageDialog(null, "Failed to retrieve user data.");
					}

					// if they dont exist in the database yet (new user), get the data directly from
					// the text fields
				} else {

					SurveyResultPanel.updateSurveyChoices(UserSetUpFrame.studentData.getUsername());
				}
			});
			//close this frame
			dispose();
		}
		
		// resetting the password
		else if (e.getSource() == resetBtn) {
			// Prompt the user to enter a new password
			String newPassword = JOptionPane.showInputDialog(this, "Enter your new password. NOTE: resetting your password will close the application");

			// check if the user entered a password
			if (newPassword != null && !newPassword.isEmpty()) {
				SwingUtilities.invokeLater(() -> {
					String username = WelcomeFrame.getDataUsername();

					// check if the user exists in the database
					if (LoginController.doesUserExist(username)) {
						StudentData userData = LoginController.getUserData(username);

						// user exists in the database, update the password
						if (userData != null) {
							LoginController.updatePassword(username, newPassword);
						} else {
							JOptionPane.showMessageDialog(null, "Failed to retrieve user data.");
						}
					} else {
						// if the user doesn't exist in the database yet (new user), update the password
						LoginController.updatePassword(UserSetUpFrame.studentData.getUsername(), newPassword);
					}
				});

				dispose();
			} else {
				// user cancelled or entered an empty password
				JOptionPane.showMessageDialog(this, "Password reset canceled.");
			}
		}

	}

	// getters and setters
	public static double getOverallAverage() {

		return overallAverage;
	}

	public static void setOverallAverage(double overallAverage) {
		StudentProfileFrame.overallAverage = overallAverage;
	}

	public static double getTotalPercent() {
		return totalPercent;
	}

	public static void setTotalPercent(double totalPercent) {
		StudentProfileFrame.totalPercent = totalPercent;
	}

	public static double getTotalCourses() {
		return totalCourses;
	}

	public static void setTotalCourses(double totalCourses) {
		StudentProfileFrame.totalCourses = totalCourses;
	}

}

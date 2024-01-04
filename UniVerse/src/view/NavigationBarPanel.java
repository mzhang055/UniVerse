/*
 * Michelle and Daniel
 * 
 * This panel is the navigation bar and it is added to the majority of the frames
 * in our program. it allows users to go to any frame they want at anytime
 */

package view;

import javax.swing.*;

import controller.LoginController;
import controller.MapController;
import controller.ScholarshipsController;
import controller.SurveyController;
import model.StudentData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBarPanel extends JPanel implements ActionListener {

	// create buttons
	private JButton homeBtn, browseProgramsBtn, universityMapBtn, surveyBtn, browseScholarships, profileBtn;

	// instance of classes
	public static StudentData studentData;
	public static StudentProfileFrame student;
	public static HomeFrame homeFrame;

	// constructor
	public NavigationBarPanel() {
		// set up panel
		setOpaque(false);
		setPreferredSize(new Dimension(1440, 115));

		// create buttons
		homeBtn = createButton(null, "images/logoBtn.png");
		browseProgramsBtn = createButton("Browse Programs", null);
		universityMapBtn = createButton("University Map", null);
		surveyBtn = createButton("Survey", null);
		browseScholarships = createButton("Browse Scholarships", null);
		profileBtn = createButton(null, "images/profileBtn.png");

		// set font size for text buttons
		Font buttonFont = new Font("Arial", Font.BOLD, 18);
		Color fontColor = Color.decode("#587494");

		// add to buttons
		browseProgramsBtn.setFont(buttonFont);
		browseProgramsBtn.setForeground(fontColor);
		universityMapBtn.setFont(buttonFont);
		universityMapBtn.setForeground(fontColor);
		surveyBtn.setFont(buttonFont);
		surveyBtn.setForeground(fontColor);
		browseScholarships.setFont(buttonFont);
		browseScholarships.setForeground(fontColor);
		profileBtn.setFont(buttonFont);
		profileBtn.setForeground(fontColor);

		// set layout manager and space out buttons
		setLayout(new FlowLayout(FlowLayout.CENTER, 70, 10));

		// add buttons to panel
		add(homeBtn);
		add(browseProgramsBtn);
		add(universityMapBtn);
		add(surveyBtn);
		add(browseScholarships);
		add(profileBtn);

		// add action listeners
		homeBtn.addActionListener(this);
		browseProgramsBtn.addActionListener(this);
		universityMapBtn.addActionListener(this);
		surveyBtn.addActionListener(this);
		browseScholarships.addActionListener(this);
		profileBtn.addActionListener(this);

	}

	// this method creates and styles the buttons with either a text or image
	// and returns the styled button
	private JButton createButton(String text, String image) {
		JButton button;
		if (image != null) {
			ImageIcon icon = new ImageIcon(image);
			button = new JButton(text, icon);
		} else {
			button = new JButton(text);
		}

		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);

		return button;
	}

	// this method hides frames when switching between them
	public static void hideFrames() {
		// Hide every other frame first
		if (ScholarshipsController.scholarshipsFrame != null)
			ScholarshipsController.scholarshipsFrame.setVisible(false);
		if (ScholarshipsController.scholarshipsFrame2 != null)
			ScholarshipsController.scholarshipsFrame2.setVisible(false);
		if (MapController.mapFrame != null)
			MapController.mapFrame.setVisible(false);
		if (UserSetUpFrame.homeFrame != null)
			UserSetUpFrame.homeFrame.dispose();
		if (WelcomeFrame.homeFrame != null)
			WelcomeFrame.homeFrame.dispose();
		if (homeFrame != null)
			homeFrame.dispose();
		if (student != null)
			student.setVisible(false);

	}

	// this method handles all user actions in the frame
	@Override
	public void actionPerformed(ActionEvent e) {

		// open home frame
		if (e.getSource() == homeBtn) {

			hideFrames();
			//check if the following frames are present. if so, set not visible
			if (SurveyController.searchFrame != null)
				SurveyController.searchFrame.setVisible(false);
			if (SurveyController.surveyFrame != null)
				SurveyController.surveyFrame.setVisible(false);
			// new HomeFrame(UserSetUpFrame.studentData.getFirstName());

			SwingUtilities.invokeLater(() -> {
				String username = WelcomeFrame.getDataUsername();

				// check if the user exists in the database
				if (LoginController.doesUserExist(username)) {
					// user exists in the database, retrieve data from the database
					StudentData userData = LoginController.getUserData(username);
					if (userData != null) {
						homeFrame = new HomeFrame(userData.getFirstName(), userData.getChoice1(), userData.getChoice2(),
								userData.getChoice3());
					} else {
						JOptionPane.showMessageDialog(null, "Failed to retrieve user data.");
					}

					// if they don't exist in the database yet (new user), get the data directly
					// from the text fields
				} else {
					String firstName = UserSetUpFrame.studentData.getFirstName();

					homeFrame = new HomeFrame(firstName, null, null, null);
				}

			});

			// open browse programs
		} else if (e.getSource() == browseProgramsBtn) {
			hideFrames();
			if (SurveyController.surveyFrame != null)
				SurveyController.surveyFrame.setVisible(false);

			SurveyController.searchFrame = new SearchAndSortFrame();

		}

		// open interactive map
		else if (e.getSource() == universityMapBtn) {

			hideFrames();
			//check if the following frames are present. if so, set not visible
			if (SurveyController.searchFrame != null)
				SurveyController.searchFrame.setVisible(false);
			if (SurveyController.surveyFrame != null)
				SurveyController.surveyFrame.setVisible(false);

			SwingUtilities.invokeLater(() -> {
				String username = WelcomeFrame.getDataUsername();

				// check if the user exists in the database
				if (LoginController.doesUserExist(username)) {
					// user exists in the database, retrieve data from the database
					StudentData userData = LoginController.getUserData(username);

					if (userData != null) {
						new MapController(userData.getLongitude(), userData.getLatitude(), userData.getBookmark1(),
								userData.getBookmark2(), userData.getBookmark3(), userData.getBookmark4(),
								userData.getBookmark5());
					} else {
						JOptionPane.showMessageDialog(null, "Failed to retrieve user data.");
					}

					// if they don't exist in the database yet (new user), get the data directly
					// from the text fields
				} else {
					String longitude = UserSetUpFrame.studentData.getLongitude();
					String latitude = UserSetUpFrame.studentData.getLatitude();

					System.out.println("Longitude for new user: " + longitude);
					System.out.println("Latitude for new user: " + latitude);

					//-1 indicates no bookmark
					new MapController(longitude, latitude, "-1", "-1", "-1", "-1", "-1");
				}

			});
		}

		// open survey button
		else if (e.getSource() == surveyBtn) {

			hideFrames();

			//if search frame is present, set to not visible
			if (SurveyController.searchFrame != null)
				SurveyController.searchFrame.setVisible(false);

			//if question controller is not null and there are no questions, set survey frame visible
			if (SurveyController.questionController != null)
				if (SurveyController.questionController.getQuestions().isEmpty())
					SurveyController.surveyFrame.setVisible(true);

			//if the welcome frame is not created, create new instance of survey and 
			if (WelcomeFrame.created == false) {
				new SurveyController();
				WelcomeFrame.created = true;

			}
			if (SurveyController.surveyFrame.isVisible() == false && WelcomeFrame.created == true)
				SurveyController.surveyFrame.setVisible(true);
		}

		// open browse jobs button
		else if (e.getSource() == browseScholarships) {
			// Hide every other frame first
			hideFrames();
			//check if the following frames are present. if so, set not visible
			if (SurveyController.searchFrame != null)
				SurveyController.searchFrame.setVisible(false);
			if (SurveyController.surveyFrame != null)
				SurveyController.surveyFrame.setVisible(false);

			//display the scholarships frame
			ScholarshipsController.scholarshipsFrame = new ScholarshipsFrame();
			ScholarshipsController.scholarshipsFrame.setVisible(true);

		}

		// open profile button
		else if (e.getSource() == profileBtn) {

			// Hide every other frame first
			hideFrames();
			//check if the following frames are present. if so, set not visible
			if (SurveyController.searchFrame != null)
				SurveyController.searchFrame.setVisible(false);
			if (SurveyController.surveyFrame != null)
				SurveyController.surveyFrame.setVisible(false);

			SwingUtilities.invokeLater(() -> {
				String username = WelcomeFrame.getDataUsername();

				// check if the user exists in the database
				if (LoginController.doesUserExist(username)) {
					// user exists in the database, retrieve data from the database
					StudentData userData = LoginController.getUserData(username);

					if (userData != null) {
						student = new StudentProfileFrame(userData.getCourse1(), userData.getGrade1(),
								userData.getCourse2(), userData.getGrade2(), userData.getCourse3(),
								userData.getGrade3(), userData.getCourse4(), userData.getGrade4(),
								userData.getCourse5(), userData.getGrade5(), userData.getCourse6(),
								userData.getGrade6(), userData.getCourse7(), userData.getGrade7(),
								userData.getCourse8(), userData.getGrade8());
					} else {
						JOptionPane.showMessageDialog(null, "Failed to retrieve user data.");
					}

					// if they dont exist in the database yet (new user), get the data directly from
					// the text fields
				} else {

					student = new StudentProfileFrame(UserSetUpFrame.studentData.getCourse1(),
							UserSetUpFrame.studentData.getGrade1(), UserSetUpFrame.studentData.getCourse2(),
							UserSetUpFrame.studentData.getGrade2(), UserSetUpFrame.studentData.getCourse3(),
							UserSetUpFrame.studentData.getGrade3(), UserSetUpFrame.studentData.getCourse4(),
							UserSetUpFrame.studentData.getGrade4(), UserSetUpFrame.studentData.getCourse5(),
							UserSetUpFrame.studentData.getGrade5(), UserSetUpFrame.studentData.getCourse6(),
							UserSetUpFrame.studentData.getGrade6(), UserSetUpFrame.studentData.getCourse7(),
							UserSetUpFrame.studentData.getGrade7(), UserSetUpFrame.studentData.getCourse8(),
							UserSetUpFrame.studentData.getGrade8());
				}
			});
		}

	}

}
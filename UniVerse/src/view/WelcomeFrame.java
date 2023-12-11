package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ConnectionController;
import model.StudentData;

public class WelcomeFrame extends JFrame implements ActionListener {
	private JTextField usernameField;
	private JTextField passwordField;
	private StudentData studentData; // create an instance of StudentData class
	private JButton getStartedBtn;
	private JButton signUpBtn;

	public WelcomeFrame() {
		// set up the frame
		super("Welcome Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 900);

		// create an instance of student data class
		studentData = new StudentData();

		// set up the background image
		ImageIcon backgroundImg = new ImageIcon("images/welcomeFrameBg.png");
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight()));

		JLabel imageLabel = new JLabel(backgroundImg);
		imageLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		Dimension imageSize = new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		imageLabel.setPreferredSize(imageSize);

		// add login text fields
		usernameField = new JTextField(); // instantiate the JTextField
		usernameField.setBounds(85, 1425, 600, 80);
		usernameField.addActionListener(this);
		usernameField.setBackground(Color.LIGHT_GRAY);
		usernameField.setFont(new Font("Arial", Font.PLAIN, 23));

		passwordField = new JTextField(); // instantiate the JTextField
		passwordField.setBounds(85, 1600, 600, 80);
		passwordField.addActionListener(this);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add the get started button
		ImageIcon getStartedIcon = new ImageIcon("images/getStartedBtn.png");
		getStartedBtn = new JButton(getStartedIcon);
		getStartedBtn.setOpaque(false);
		getStartedBtn.setContentAreaFilled(false);
		getStartedBtn.setBorderPainted(false);
		getStartedBtn.setBounds(270, 1725, getStartedIcon.getIconWidth(), getStartedIcon.getIconHeight());
		getStartedBtn.addActionListener(this);

		// add the sign up button
		ImageIcon signUpIcon = new ImageIcon("images/signUpBtn.png");
		signUpBtn = new JButton(signUpIcon);
		signUpBtn.setOpaque(false);
		signUpBtn.setContentAreaFilled(false);
		signUpBtn.setBorderPainted(false);
		signUpBtn.setBounds(960, 1550, signUpIcon.getIconWidth(), signUpIcon.getIconHeight());
		signUpBtn.addActionListener(this);

		// adding components to the layered pane
		layeredPane.add(imageLabel, Integer.valueOf(0));
		layeredPane.add(usernameField, Integer.valueOf(1));
		layeredPane.add(passwordField, Integer.valueOf(1));
		layeredPane.add(getStartedBtn, Integer.valueOf(1));
		layeredPane.add(signUpBtn, Integer.valueOf(1));

		// add the layered pane to the scroll pane
		JScrollPane jsp = new JScrollPane(layeredPane);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.getVerticalScrollBar().setUnitIncrement(12);

		// add the scroll pane to the content pane
		getContentPane().add(jsp);

		// set frame visible
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// handle case where get started button is clicked
		if (e.getSource() == getStartedBtn) {
			// get the data the user entered in the text fields
			String dataUsername = usernameField.getText().trim();
			String dataPassword = passwordField.getText().trim();
			System.out.println("Data submitted - Username: " + dataUsername + ", Password: " + dataPassword); // testing

			PreparedStatement ps;
			ResultSet rs;

			String query = "SELECT * FROM `app_users` WHERE `username` =? AND `password` =?";

			try {
				ps = ConnectionController.getConnection().prepareStatement(query);

				ps.setString(1, dataUsername);
				ps.setString(2, dataPassword);

				rs = ps.executeQuery();

				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Successful Login");
						// open the home screen
						new HomeFrame();
						dispose(); // close current frame
				}

				else {
					JOptionPane.showMessageDialog(null, "Invalid Login.");
					new WelcomeFrame();
					dispose();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		// handle the case where the sign up button is clicked
		else if (e.getSource() == signUpBtn) {
			// open the user set up frame and close current frame
			new UserSetUpFrame();
			dispose();
		}
	}

	public static void main(String[] args) {
		new WelcomeFrame();
	}
}

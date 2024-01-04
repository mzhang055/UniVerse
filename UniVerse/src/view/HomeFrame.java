/*
 * Michelle Zhang
 * This program is responsible for creating and displaying the home frame
 * to the user. This frame is like the user's personal dashboard where they can view
 * their past survey choices (ranked list of top 3 choices), hyperlinks to important
 * resources (OSAP, OUAC, ONtransition), and also prompts the user to start the survey 
 * if they dont know where to begin
 */

package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import controller.SurveyController;

public class HomeFrame extends JFrame implements ActionListener {

	//create buttons for the frame
	private JButton ouacBtn, ontransferBtn, osapBtn, surveyBtn;

	//constructor
	public HomeFrame(String firstName, String choice1, String choice2, String choice3) {
		//set up the frame
		super("Home Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 900);

		// set the background image and add it to a label
		ImageIcon backgroundImg = new ImageIcon("images/homeBg.png");
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight()));
		
		JLabel imageLabel = new JLabel(backgroundImg);
		imageLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		Dimension imageSize = new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		imageLabel.setPreferredSize(imageSize);

		// display the user's first name
		JLabel nameLabel = new JLabel("Welcome, " + firstName);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 40));
		nameLabel.setBounds(580, 220, 600, 50);
		layeredPane.add(nameLabel, Integer.valueOf(1));

		// add the navigation panel
		NavigationBarPanel navBarPanel = new NavigationBarPanel();
		navBarPanel.setBounds(0, 0, 1440, 90);
		layeredPane.add(navBarPanel, Integer.valueOf(1));

		// add background image to the last layer
		layeredPane.add(imageLabel, Integer.valueOf(0));
		getContentPane().add(layeredPane);

		//set visible
		setVisible(true);

		// if the user has not filled out the survey yet,
		// display that there is no survey data yet
		if (choice1 == null && choice2 == null && choice3 == null) {
			JLabel choice1Label = new JLabel("No survey data yet!");
			choice1Label.setForeground(Color.decode("#587494"));
			choice1Label.setFont(new Font("Arial", Font.BOLD, 20));
			choice1Label.setBounds(70, 700, 300, 30);
			layeredPane.add(choice1Label, Integer.valueOf(1));

			JLabel choice2Label = new JLabel("No survey data yet!");
			choice2Label.setForeground(Color.decode("#587494"));
			choice2Label.setFont(new Font("Arial", Font.BOLD, 20));
			choice2Label.setBounds(350, 700, 300, 30);
			layeredPane.add(choice2Label, Integer.valueOf(1));

			JLabel choice3Label = new JLabel("No survey data yet!");
			choice3Label.setForeground(Color.decode("#587494"));
			choice3Label.setFont(new Font("Arial", Font.BOLD, 20));
			choice3Label.setBounds(620, 700, 300, 30);
			layeredPane.add(choice3Label, Integer.valueOf(1));
		}

		// however, if they have filled out the survey, 
		//display user's most recent survey choices 1 to 3
		else {
			JLabel choice1Label = new JLabel("1. " + choice1);
			choice1Label.setForeground(Color.decode("#587494"));
			choice1Label.setFont(new Font("Arial", Font.BOLD, 20));
			choice1Label.setBounds(70, 700, 300, 30);
			layeredPane.add(choice1Label, Integer.valueOf(1));

			JLabel choice2Label = new JLabel("2. " + choice2);
			choice2Label.setForeground(Color.decode("#587494"));
			choice2Label.setFont(new Font("Arial", Font.BOLD, 20));
			choice2Label.setBounds(350, 700, 300, 30);
			layeredPane.add(choice2Label, Integer.valueOf(1));

			JLabel choice3Label = new JLabel("3. " + choice3);
			choice3Label.setForeground(Color.decode("#587494"));
			choice3Label.setFont(new Font("Arial", Font.BOLD, 20));
			choice3Label.setBounds(620, 700, 300, 30);
			layeredPane.add(choice3Label, Integer.valueOf(1));
		}

		// add the ouac button which leads to a browser link
		ImageIcon ouacIcon = new ImageIcon("images/ouac.png");
		ouacBtn = new JButton(ouacIcon);
		ouacBtn.setOpaque(false);
		ouacBtn.setContentAreaFilled(false);
		ouacBtn.setBorderPainted(false);
		ouacBtn.setBounds(120, 410, ouacIcon.getIconWidth(), ouacIcon.getIconHeight());
		ouacBtn.addActionListener(this);
		layeredPane.add(ouacBtn, Integer.valueOf(1));

		// add the ontransfer button which leads to a browser link
		ImageIcon ontransferIcon = new ImageIcon("images/ontransfer.png");
		ontransferBtn = new JButton(ontransferIcon);
		ontransferBtn.setOpaque(false);
		ontransferBtn.setContentAreaFilled(false);
		ontransferBtn.setBorderPainted(false);
		ontransferBtn.setBounds(500, 420, ontransferIcon.getIconWidth(), ontransferIcon.getIconHeight());
		ontransferBtn.addActionListener(this);
		layeredPane.add(ontransferBtn, Integer.valueOf(1));

		// add the osap button which leads to a browser link
		ImageIcon osapIcon = new ImageIcon("images/osap.png");
		osapBtn = new JButton(osapIcon);
		osapBtn.setOpaque(false);
		osapBtn.setContentAreaFilled(false);
		osapBtn.setBorderPainted(false);
		osapBtn.setBounds(1100, 400, osapIcon.getIconWidth(), osapIcon.getIconHeight());
		osapBtn.addActionListener(this);
		layeredPane.add(osapBtn, Integer.valueOf(1));

		//prompt user to take the survey if they dont know where to begin
		JLabel surveyLabel = new JLabel("Don't know what to study? Learn more!");
		surveyLabel.setForeground(Color.decode("#587494"));
		surveyLabel.setFont(new Font("Arial", Font.BOLD, 18));
		surveyLabel.setBounds(950, 550, 900, 200);
		layeredPane.add(surveyLabel, Integer.valueOf(1));

		//add the button that leads to the survey
		ImageIcon surveyIcon = new ImageIcon("images/retakeBtn.png");
		surveyBtn = new JButton(surveyIcon);
		surveyBtn.setOpaque(false);
		surveyBtn.setContentAreaFilled(false);
		surveyBtn.setBorderPainted(false);
		surveyBtn.setBounds(1000, 700, osapIcon.getIconWidth(), osapIcon.getIconHeight());
		surveyBtn.addActionListener(this);
		layeredPane.add(surveyBtn, Integer.valueOf(1));

	}

	// this method handles links to open webpages on browsers
	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// handles all user actions
	@Override
	public void actionPerformed(ActionEvent e) {

		// when the user clicks on the ouac, ontransfer, or osap button, it leads them
		// to the correpsonding website
		if (e.getSource() == ouacBtn) {
			openWebpage("https://www.ouac.on.ca/");
		}

		else if (e.getSource() == ontransferBtn) {
			openWebpage("https://ontransfer.ca/i/ontransfer+home");
		}

		else if (e.getSource() == osapBtn) {
			openWebpage("https://www.ontario.ca/page/osap-ontario-student-assistance-program");
		}

		//open the survey
		else if (e.getSource() == surveyBtn) {
			new SurveyController();
			dispose();
		}

	}

}

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class HomeFrame extends JFrame implements ActionListener {

	public HomeFrame(String firstName) {
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

		// display the user's first name
		JLabel nameLabel = new JLabel("Welcome, " + firstName);
		nameLabel.setForeground(Color.decode("#587494"));
		nameLabel.setFont(new Font("Arial", Font.BOLD, 25));
		nameLabel.setBounds(30, 200, 300, 30);
		layeredPane.add(nameLabel, Integer.valueOf(1));

		// add the navigation panel
		NavigationBarPanel navBarPanel = new NavigationBarPanel();
		navBarPanel.setBounds(0, 0, 1440, 90);
		layeredPane.add(navBarPanel, Integer.valueOf(1));

		// add background image to the last layer
		layeredPane.add(imageLabel, Integer.valueOf(0));
		getContentPane().add(layeredPane);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	

}

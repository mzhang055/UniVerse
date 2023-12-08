package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UserSetUpFrame extends JFrame implements ActionListener {

	// fields for user personal information
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField unitField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField postalCodeField;
	private JTextField provinceField;
	private JTextField countryField;

	// fields for user academic information

    private JTextField numCoursesField;
    private JButton confirmBtn;
    private JButton submitCoursesBtn;
    private JButton getStartedBtn;
    private JLayeredPane layeredPane;
    private JTextField lastGradeField; //used to track last grade field to add button dynamically

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

		
		//--- Personal Info
		// add first name text field
		firstNameField = new JTextField(); // instantiate the JTextField
		firstNameField.setBounds(100, 300, 500, 80);
		firstNameField.addActionListener(this);
		firstNameField.setBackground(Color.LIGHT_GRAY);
		firstNameField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add last name text field
		lastNameField = new JTextField(); // instantiate the JTextField
		lastNameField.setBounds(745, 300, 500, 80);
		lastNameField.addActionListener(this);
		lastNameField.setBackground(Color.LIGHT_GRAY);
		lastNameField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add unit text field
		unitField = new JTextField(); // instantiate the JTextField
		unitField.setBounds(100, 450, 500, 80);
		unitField.addActionListener(this);
		unitField.setBackground(Color.LIGHT_GRAY);
		unitField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add address field
		addressField = new JTextField(); // instantiate the JTextField
		addressField.setBounds(745, 450, 500, 80);
		addressField.addActionListener(this);
		addressField.setBackground(Color.LIGHT_GRAY);
		addressField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add city field
		cityField = new JTextField(); // instantiate the JTextField
		cityField.setBounds(100, 570, 500, 80);
		cityField.addActionListener(this);
		cityField.setBackground(Color.LIGHT_GRAY);
		cityField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add postal code field
		postalCodeField = new JTextField(); // instantiate the JTextField
		postalCodeField.setBounds(745, 570, 500, 80);
		postalCodeField.addActionListener(this);
		postalCodeField.setBackground(Color.LIGHT_GRAY);
		postalCodeField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add province field
		provinceField = new JTextField(); // instantiate the JTextField
		provinceField.setBounds(100, 700, 500, 80);
		provinceField.addActionListener(this);
		provinceField.setBackground(Color.LIGHT_GRAY);
		provinceField.setFont(new Font("Arial", Font.PLAIN, 23));

		// add country field
		countryField = new JTextField(); // instantiate the JTextField
		countryField.setBounds(745, 700, 500, 80);
		countryField.addActionListener(this);
		countryField.setBackground(Color.LIGHT_GRAY);
		countryField.setFont(new Font("Arial", Font.PLAIN, 23));
		
		
		//--- Academic Info
		numCoursesField = new JTextField();
		numCoursesField.setBounds(100, 930, 200, 80);;
		numCoursesField.addActionListener(this);
		numCoursesField.setBackground(Color.LIGHT_GRAY);
		numCoursesField.setFont(new Font("Arial", Font.PLAIN, 23));

		
        ImageIcon confirmIcon = new ImageIcon("images/confirmBtn.png");
        confirmBtn = new JButton(confirmIcon);
        confirmBtn.setOpaque(false);
        confirmBtn.setContentAreaFilled(false);
        confirmBtn.setBorderPainted(false);
        confirmBtn.setBounds(320, 940, confirmIcon.getIconWidth(), confirmIcon.getIconHeight());
        confirmBtn.addActionListener(this);
		
		
		
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
		layeredPane.add(numCoursesField, Integer.valueOf(1));
		layeredPane.add(confirmBtn, Integer.valueOf(1));
		

		// add layered pane to scroll pane
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
        if (e.getSource() == confirmBtn) {
            try {
                int numCourses = Integer.parseInt(numCoursesField.getText().trim());
                createCourseFields(numCourses);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        }
        
        else if(e.getSource() == getStartedBtn) {
        	//get the data from text fields
        	String dataFirstName = firstNameField.getText().trim();
           	String dataLastName = lastNameField.getText().trim();
           	String dataUnit = unitField.getText().trim();
           	String dataAddress = addressField.getText().trim();
           	String dataCity = cityField.getText().trim();
           	String dataPostalCode = postalCodeField.getText().trim();
           	String dataProvince = provinceField.getText().trim();
           	String dataCountry = countryField.getText().trim();
        	


        	
        	
        	//open home frame and close current frame
        	new HomeFrame();
        	dispose();
        }
    }


	   private void createCourseFields(int numCourses) {

	        // add text fields for course code and grade dynamically
	        for (int i = 0; i < numCourses; i++) {
	            JTextField courseCodeField = new JTextField();
	            JTextField gradeField = new JTextField();

	            int xCoordinate = 100;
	            int yCoordinate = 1100 + i * 100; //create even spacing

	            JLabel courseCodeLabel = new JLabel("Course Code:");
	            courseCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	            courseCodeLabel.setBounds(xCoordinate, yCoordinate, 250, 50);
	            layeredPane.add(courseCodeLabel, Integer.valueOf(1));

	            courseCodeField.setBounds(xCoordinate + 150, yCoordinate, 200, 50);
	            layeredPane.add(courseCodeField, Integer.valueOf(1));

	            JLabel gradeLabel = new JLabel("Grade:");
	            gradeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	            gradeLabel.setBounds(xCoordinate + 350, yCoordinate, 250, 50);
	            layeredPane.add(gradeLabel, Integer.valueOf(1));

	            gradeField.setBounds(xCoordinate + 500, yCoordinate, 200, 50);
	            layeredPane.add(gradeField, Integer.valueOf(1));
	            
	            lastGradeField = gradeField;
	        }
	        // place continue button below the last text field
	        if (lastGradeField != null) {
	            int buttonYCoordinate = lastGradeField.getY() + lastGradeField.getHeight() + 15; //15 is the spacing 
	            ImageIcon getStartedIcon = new ImageIcon("images/getStartedBtn.png");
	            getStartedBtn = new JButton(getStartedIcon);
	            getStartedBtn.setOpaque(false);
	            getStartedBtn.setContentAreaFilled(false);
	            getStartedBtn.setBorderPainted(false);
	            getStartedBtn.setBounds(320, buttonYCoordinate, getStartedIcon.getIconWidth(), getStartedIcon.getIconHeight());
	            getStartedBtn.addActionListener(this);
	            layeredPane.add(getStartedBtn, Integer.valueOf(1));
	        }

	        // repaint the frame
	        revalidate();
	        repaint();
	    }


	    
	public static void main(String[] args) {
		new UserSetUpFrame();
	}

}

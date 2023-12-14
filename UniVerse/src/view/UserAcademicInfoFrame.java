package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAcademicInfoFrame extends JFrame implements ActionListener {

    private JFrame createCourseFrame;
    private JTextField courseCodeField;
    private JTextField gradeField;
    
	// fields for user academic information
	private JTextField numCoursesField;
	private JButton confirmBtn;
	private JButton getStartedBtn;
	private JLayeredPane layeredPane;

	private JTextField lastGradeField; // used to track last grade field to add button dynamically


    public UserAcademicInfoFrame() {
        // Create a new JFrame for course creation
        createCourseFrame = new JFrame("Create Course");
        createCourseFrame.setSize(1440, 900);
        createCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set background color using a hex code (e.g., light blue)
        createCourseFrame.getContentPane().setBackground(Color.decode("#ADD8E6"));

        // Add text fields and labels for course code and grade
        courseCodeField = new JTextField();
        gradeField = new JTextField();
        
		// set the background colour for all text fields.
		Color color = new Color(245, 245, 245);

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
        createCourseFrame.add(courseCodeField);
        createCourseFrame.add(gradeField);

        // Add a button with an image
        JButton saveCourseBtn = new JButton();
        saveCourseBtn.setIcon(new ImageIcon("")); 
        createCourseFrame.add(saveCourseBtn);

        // Set layout manager as needed

        createCourseFrame.setLayout(new FlowLayout());  
        createCourseFrame.setVisible(true);
        
     
    }

    
	private void createCourseFields(int numCourses) {

		// add text fields for course code and grade dynamically
		for (int i = 0; i < numCourses; i++) {
			courseCodeField = new JTextField();
			gradeField = new JTextField();

			int xCoordinate = 100;
			int yCoordinate = 1550 + i * 100; // create even spacing

			JLabel courseCodeLabel = new JLabel("Course Code:");
			courseCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			courseCodeLabel.setBounds(xCoordinate, yCoordinate, 250, 50);
			layeredPane.add(courseCodeLabel, Integer.valueOf(2));

			courseCodeField.setBounds(xCoordinate + 150, yCoordinate, 200, 50);
			layeredPane.add(courseCodeField, Integer.valueOf(2));

			JLabel gradeLabel = new JLabel("Grade:");
			gradeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			gradeLabel.setBounds(xCoordinate + 350, yCoordinate, 250, 50);
			layeredPane.add(gradeLabel, Integer.valueOf(2));

			gradeField.setBounds(xCoordinate + 500, yCoordinate, 200, 50);
			layeredPane.add(gradeField, Integer.valueOf(2));

			lastGradeField = gradeField;
		}
		// place continue button below the last text field
		if (lastGradeField != null) {
			int buttonYCoordinate = lastGradeField.getY() + lastGradeField.getHeight() + 15; // 15 is the spacing
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

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserAcademicInfoFrame());
    }
}

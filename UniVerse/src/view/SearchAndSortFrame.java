/*
Name: Johnny Xu
Date: Dec 14, 2023
Course: ICSU1
Features: - sorting by category, university, or all programs (display categories, universities) 
            - searching for specific programs by keywords 
            - filtering by narrowing down by universities, categories, co-op options, grade range 
Major Skills: -JSoup and Opencsv API 
Areas of Concern: -the format of programs displayed on panel
*/
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ProgramFileInput;

/*
* https://stackoverflow.com/questions/3333623/how-to-get-rid-of-the-border-with-a-jtable-jscrollpane#:~:text=by%20using%3A,it%20works.
*/

public class SearchAndSortFrame extends JFrame implements ActionListener {

    //calling file input class
	ProgramFileInput fileInput = new ProgramFileInput();

	//Array List for JLabels that for all sorting action listener 
	ArrayList<JLabel> JLabelArray = new ArrayList<JLabel>();

	// initializing GUI elements
	private NavigationBarPanel topBar;
	private JLabel backgroundImage = new JLabel(new ImageIcon("images/background.png"));
	private JLabel BrowseLabel = new JLabel(new ImageIcon("images/Browse By_.png"));
	private JLabel ProgramLabel = new JLabel(new ImageIcon("images/Find a Program_.png"));
	private JButton SearchButton = new JButton(new ImageIcon("images/image 2.png"));
	private JButton sortButton = new JButton ("Sort");
	private JTextField search = new JTextField("Enter Program Name");
	
	private JLabel advancedSearchLabel = new JLabel(new ImageIcon("images/Advanced Filtering_.png"));
	private JLabel uniLabel = new JLabel("University:");
	private JLabel catLabel = new JLabel("Category:");
	private JLabel coopeLabel = new JLabel("Co-op:");
	private JLabel gradeLabel = new JLabel("Grade Range:");

	private JPanel panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(panel);

	String[] sortBy = { "Category", "University", "All Programs" };
	private JComboBox<String> sortList = new JComboBox<String>(sortBy);
	String[] uni = {" ", "Brock University", "Carleton University", "University of Guelph",
			 "Lakehead University", "Laurentian University", "McMaster University",
			"Nipissing University", "OCAD University", "Ontario Tech University",
			"University of Ottawa", "Queen's University", "Royal Military College of Canada", "University of Toronto",
			"Toronto Metropolitan University", "Trent University",
			"University of Waterloo", "Western University", "Wilfrid Laurier University", "University of Windsor",
			"York University", };
	private JComboBox<String> uniList = new JComboBox<String>(uni);

	String[] category = { " ", "Architecture", "Biological Sciences", "Business Studies", "Computer Science",
			"Creative Art And Design", "Engineering", "Health Sciences", "Mathematics", "Physical Sciences",
			"Social Sciences", "Media" };
	private JComboBox<String> categoryList = new JComboBox<String>(category);

	String[] experiential = { " ", "Co-op", "Not Available" };
	private JComboBox<String> experientialList = new JComboBox<String>(experiential);

	String[] grade = { " ", "60", "70", "80", "90"};
	private JComboBox<String> gradeList = new JComboBox<String>(grade);

	private JButton cat1 = new JButton("Architecture");
	private JButton cat2 = new JButton("Biological Sciences");
	private JButton cat3 = new JButton("Business Studies");
	private JButton cat4 = new JButton("Computer Science");
	private JButton cat5 = new JButton("Creative Art And Design");
	private JButton cat6 = new JButton("Engineering");
	private JButton cat7 = new JButton("Health Sciences");
	private JButton cat8 = new JButton("Mathematics");
	private JButton cat9 = new JButton("Physical Sciences");
	private JButton cat10 = new JButton("Social Sciences");
	private JButton cat11 = new JButton("Media");

	private JButton uni2 = new JButton("Brock University");
	private JButton uni3 = new JButton("Carleton University");
	private JButton uni4 = new JButton("University of Guelph");

	private JButton uni6 = new JButton("Lakehead University");
	private JButton uni7 = new JButton("Laurentian University");
	private JButton uni8 = new JButton("McMaster University");
	private JButton uni9 = new JButton("Nipissing University");
	private JButton uni10 = new JButton("OCAD University");

	private JButton uni12 = new JButton("Ontario Tech University");
	private JButton uni13 = new JButton("University of Ottawa");
	private JButton uni14 = new JButton("Queen's University");
	private JButton uni15 = new JButton("Royal Military College of Canada");
	private JButton uni16 = new JButton("University of Toronto");
	private JButton uni17 = new JButton("Toronto Metropolitan University (formerly Ryerson University)");
	private JButton uni18 = new JButton("Trent University");
	private JButton uni19 = new JButton("University of Waterloo");
	private JButton uni20 = new JButton("Western University");
	private JButton uni21 = new JButton("Wilfrid Laurier University");
	private JButton uni22 = new JButton("University of Windsor");
	private JButton uni23 = new JButton("York University");

	public SearchAndSortFrame() {

		setTitle("Browsing"); // title
		setSize(1440, 900);  //set screen size 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

        //implement and set location for navigation bar 
		topBar = new NavigationBarPanel();
		topBar.setBounds(0, 0, 1440, 115);
		getContentPane().add(topBar);

		// setup the input objects
		BrowseLabel.setBounds(5, 150, 200, 100);
		getContentPane().add(BrowseLabel);

		ProgramLabel.setBounds(-15, 350, 300, 100);
		getContentPane().add(ProgramLabel);
		
		advancedSearchLabel.setBounds(10, 500, 300, 100);
		advancedSearchLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		getContentPane().add(advancedSearchLabel);
		
		uniLabel.setBounds(25, 525, 300, 100);
		getContentPane().add(uniLabel);
		
		catLabel.setBounds(25, 575, 300, 100);
		getContentPane().add(catLabel);
		
		coopeLabel.setBounds(25, 625, 300, 100);
		getContentPane().add(coopeLabel);
		
		gradeLabel.setBounds(25, 675, 300, 100);
		getContentPane().add(gradeLabel);

		sortList.setBounds(20, 200, 200, 50);
		getContentPane().add(sortList);
		sortList.addActionListener(this);

		search.setBounds(20, 415, 150, 50);
		search.setForeground(Color.gray);
		getContentPane().add(search);
		search.addActionListener(this);

		SearchButton.setBounds(165, 415, 50, 50);
		getContentPane().add(SearchButton);
		SearchButton.addActionListener(this);

		sortButton.setBounds(165, 775, 50, 25);
		getContentPane().add(sortButton);
		sortButton.addActionListener(this);
		
		uniList.setBounds(20, 575, 200, 50);
		getContentPane().add(uniList);
		

		categoryList.setBounds(20, 625, 200, 50);
		getContentPane().add(categoryList);
		

		experientialList.setBounds(20, 675, 200, 50);
		getContentPane().add(experientialList);
		

		gradeList.setBounds(20, 725, 200, 50);
		getContentPane().add(gradeList);
	

		panel.setLayout(null);  //allow set bound on the panel 
		panel.setPreferredSize(new Dimension(975, 665)); //customize dimension of panel size 

		scrollPane.setBounds(320, 150, 1000, 675); //panel location 
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //always show vertical scroll bar 
		scrollPane. getVerticalScrollBar(). setUnitIncrement(16); //customize speed of scroll bar 
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  //never show horizontal scroll bar 
		scrollPane.setViewportView(panel); //adding panel to scroll pane 
		getContentPane().add(scrollPane);  //adding scroll pane to the frame 

                //setting bounds for category buttons 
		cat1.setBounds(0, 10, 975, 50);
		cat1.addActionListener(this);
		panel.add(cat1);
		cat2.setBounds(0, 70, 975, 50);
		cat2.addActionListener(this);
		panel.add(cat2);
		cat3.setBounds(0, 130, 975, 50);
		cat3.addActionListener(this);
		panel.add(cat3);
		cat4.setBounds(0, 190, 975, 50);
		cat4.addActionListener(this);
		panel.add(cat4);
		cat5.setBounds(0, 250, 975, 50);
		cat5.addActionListener(this);
		panel.add(cat5);
		cat6.setBounds(0, 310, 975, 50);
		cat6.addActionListener(this);
		panel.add(cat6);
		cat7.setBounds(0, 370, 975, 50);
		cat7.addActionListener(this);
		panel.add(cat7);
		cat8.setBounds(0, 430, 975, 50);
		cat8.addActionListener(this);
		panel.add(cat8);
		cat9.setBounds(0, 490, 975, 50);
		cat9.addActionListener(this);
		panel.add(cat9);
		cat10.setBounds(0, 550, 975, 50);
		cat10.addActionListener(this);
		panel.add(cat10);
		cat11.setBounds(0, 610, 975, 50);
		cat11.addActionListener(this);
		panel.add(cat11);

		validate(); // image validation
		getContentPane().add(backgroundImage); // attaching background image

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
                //if sort button is pressed (filter) 
		if (event.getSource() == sortButton) {
			
                        //create variables to store selected options 
			String uni = (String) uniList.getSelectedItem();
			String category = (String) categoryList.getSelectedItem();
			String experiential = (String) experientialList.getSelectedItem();
			String grade = (String) gradeList.getSelectedItem();
			
			panel.removeAll(); //removing all elements on current panel 
			JLabelArray.removeAll(JLabelArray);  //removing all JLabels on current frame 

			
                        //looping through all programs to check for matches
			for (int i = 0; i < 2064; i++) {
                                
                                //if program is matched with respect to string variables 
				if (fileInput.getProgramArray()[i].getUniversityName().contains(uni) && fileInput.getProgramArray()[i].getCategory().contains(category) && fileInput.getProgramArray()[i].getCoopAvailable().contains(experiential) && fileInput.getProgramArray()[i].getGradeRange().contains(grade)) {

                                        //add matched programs with approbate format 
					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"", fileInput.getProgramArray()[i].toString())));
				}
			}
                        //customize spacing between programs 
			int spacing = 200; 
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
                                //set panel length with respect to size of JLabels 
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
			
                        //if no matches to filtered selections 
			if (JLabelArray.size() == 0)
                                //display message: 
				JOptionPane.showMessageDialog(null, "No MATCHES, Please try again.");
		}
                
                //if search button is pressed (filter) 
		if (event.getSource() == SearchButton) {

			panel.removeAll(); //removing all elements on current panel 
			JLabelArray.removeAll(JLabelArray);  //removing all JLabels on current frame 

                        //create variables to store keyword
			String keyword = search.getText();

                        //looping through all programs to check for matches
			for (int i = 0; i < 2064; i++) {

                                //if program is matched with respect to string variables 
				if (fileInput.getProgramArray()[i].toString().contains(keyword)) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == cat1) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Architecture")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == cat2) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Biological Sciences")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat3) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Business Studies")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat4) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Computer Science")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat5) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Creative Arts And Design")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat6) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Engineering")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat7) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Health Sciences")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat8) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Mathematics")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat9) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Physical Sciences")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat10) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Social Sciences")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}

		if (event.getSource() == cat11) {
			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().contains("Media")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page

		}


		if (event.getSource() == uni2) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Brock University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni3) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Carleton University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni4) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("University of Guelph")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}


		if (event.getSource() == uni6) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Lakehead University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni7) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Laurentian University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni8) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("McMaster University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni9) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Nipissing University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni10) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("OCAD University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni12) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Ontario Tech University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni13) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("University of Ottawa")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni14) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Queen's University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni15) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Royal Military College of Canada")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni16) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("University of Toronto")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni17) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName()
						.contains("Toronto Metropolitan University (formerly Ryerson University)")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni18) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Trent University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni19) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("University of Waterloo")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni20) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);
			
			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Western University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni21) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("Wilfrid Laurier University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni22) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("University of Windsor")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == uni23) {

			// removes all button from panel
			panel.removeAll();
			JLabelArray.removeAll(JLabelArray);

			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getUniversityName().contains("York University")) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
			}
			int spacing = 200;
			for (int x = 0; x < JLabelArray.size(); x++) {

				JLabel jlabel = JLabelArray.get(x);
				jlabel.setBounds(0, 0 + x * spacing, 975, 200);
				panel.add(jlabel);
				
				panel.setPreferredSize(new Dimension(2000, 200 * JLabelArray.size() + 50));
			}
			repaint();
			revalidate(); // reload the page
		}

		if (event.getSource() == sortList) {
			// action listeners for selected options
			String sortOption1 = (String) sortList.getSelectedItem();
			if (sortOption1 == "Category") {
				panel.setPreferredSize(new Dimension(975, 665));  //set panel length to match amount of buttons 
				// removes all button from panel
				panel.removeAll();
				JLabelArray.removeAll(JLabelArray);

				// adding new buttons
				cat1.setBounds(0, 10, 975, 50);
				panel.add(cat1);
				cat2.setBounds(0, 70, 975, 50);
				panel.add(cat2);
				cat3.setBounds(0, 130, 975, 50);
				panel.add(cat3);
				cat4.setBounds(0, 190, 975, 50);
				panel.add(cat4);
				cat5.setBounds(0, 250, 975, 50);
				panel.add(cat5);
				cat6.setBounds(0, 310, 975, 50);
				panel.add(cat6);
				cat7.setBounds(0, 370, 975, 50);
				panel.add(cat7);
				cat8.setBounds(0, 430, 975, 50);
				panel.add(cat8);
				cat9.setBounds(0, 490, 975, 50);
				panel.add(cat9);
				cat10.setBounds(0, 550, 975, 50);
				panel.add(cat10);
				cat11.setBounds(0, 610, 975, 50);
				panel.add(cat11);

				revalidate();
				// reload the page
				repaint();

			}

			String sortOption2 = (String) sortList.getSelectedItem();
			if (sortOption2 == "University") {
				panel.setPreferredSize(new Dimension(975, 1200));  //set panel length to match amount of buttons 
				// removes all button from panel
				panel.removeAll();
				JLabelArray.removeAll(JLabelArray);

				// adding new buttons
				uni2.setBounds(0, 10, 975, 50);
				uni2.addActionListener(this);
				panel.add(uni2);
				uni3.setBounds(0, 70, 975, 50);
				uni3.addActionListener(this);
				panel.add(uni3);
				uni4.setBounds(0, 130, 975, 50);
				uni4.addActionListener(this);
				panel.add(uni4);
				uni6.setBounds(0, 190, 975, 50);
				uni6.addActionListener(this);
				panel.add(uni6);
				uni7.setBounds(0, 250, 975, 50);
				uni7.addActionListener(this);
				panel.add(uni7);
				uni8.setBounds(0, 310, 975, 50);
				uni8.addActionListener(this);
				panel.add(uni8);
				uni9.setBounds(0, 370, 975, 50);
				uni9.addActionListener(this);
				panel.add(uni9);
				uni10.setBounds(0, 430, 975, 50);
				uni10.addActionListener(this);
				panel.add(uni10);
				uni12.setBounds(0, 490, 975, 50);
				uni12.addActionListener(this);
				panel.add(uni12);
				uni13.setBounds(0, 550, 975, 50);
				uni13.addActionListener(this);
				panel.add(uni13);
				uni14.setBounds(0, 610, 975, 50);
				uni14.addActionListener(this);
				panel.add(uni14);
				uni15.setBounds(0, 670, 975, 50);
				uni15.addActionListener(this);
				panel.add(uni15);
				uni16.setBounds(0, 730, 975, 50);
				uni16.addActionListener(this);
				panel.add(uni16);
				uni17.setBounds(0, 790, 975, 50);
				uni17.addActionListener(this);
				panel.add(uni17);
				uni18.setBounds(0, 850, 975, 50);
				uni18.addActionListener(this);
				panel.add(uni18);
				uni19.setBounds(0, 910, 975, 50);
				uni19.addActionListener(this);
				panel.add(uni19);
				uni20.setBounds(0, 970, 975, 50);
				uni20.addActionListener(this);
				panel.add(uni20);
				uni21.setBounds(0, 1030, 975, 50);
				uni21.addActionListener(this);
				panel.add(uni21);
				uni22.setBounds(0, 1090, 975, 50);
				uni22.addActionListener(this);
				panel.add(uni22);
				uni23.setBounds(0, 1150, 975, 50);
				uni23.addActionListener(this);
				panel.add(uni23);

				revalidate();
				// reload the page
				repaint();

			}

			String sortOption3 = (String) sortList.getSelectedItem();
			if (sortOption3 == "All Programs") {

				// removes all button from panel
				panel.removeAll();
				JLabelArray.removeAll(JLabelArray);
				panel.setPreferredSize(new Dimension(2000, 200 * 2064 + 50));  //set panel length to match amount of programs 
				

				for (int i = 0; i < 2064; i++) {

					JLabelArray.add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"", fileInput.getProgramArray()[i].toString())));
				}

				int spacing = 200;
				for (int x = 0; x < JLabelArray.size(); x++) {

					JLabel jlabel = JLabelArray.get(x);
					jlabel.setBounds(0, 10 + x * spacing, 2000, 200);
					panel.add(jlabel);
					
					
				}
				repaint();
				revalidate(); //reload the page

			}
		}
	}

	public ProgramFileInput getFileInput() {
		return fileInput;
	}

	public void setFileInput(ProgramFileInput fileInput) {
		this.fileInput = fileInput;
	}

	public ArrayList<JLabel> getJLabelArray() {
		return JLabelArray;
	}

	public void setJLabelArray(ArrayList<JLabel> jLabelArray) {
		JLabelArray = jLabelArray;
	}

	public NavigationBarPanel getTopBar() {
		return topBar;
	}

	public void setTopBar(NavigationBarPanel topBar) {
		this.topBar = topBar;
	}

	public JLabel getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(JLabel backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public JLabel getBrowseLabel() {
		return BrowseLabel;
	}

	public void setBrowseLabel(JLabel browseLabel) {
		BrowseLabel = browseLabel;
	}

	public JLabel getProgramLabel() {
		return ProgramLabel;
	}

	public void setProgramLabel(JLabel programLabel) {
		ProgramLabel = programLabel;
	}

	public JButton getSearchButton() {
		return SearchButton;
	}

	public void setSearchButton(JButton searchButton) {
		SearchButton = searchButton;
	}

	public JButton getSortButton() {
		return sortButton;
	}

	public void setSortButton(JButton sortButton) {
		this.sortButton = sortButton;
	}

	public JTextField getSearch() {
		return search;
	}

	public void setSearch(JTextField search) {
		this.search = search;
	}

	public JLabel getAdvancedSearchLabel() {
		return advancedSearchLabel;
	}

	public void setAdvancedSearchLabel(JLabel advancedSearchLabel) {
		this.advancedSearchLabel = advancedSearchLabel;
	}

	public JLabel getUniLabel() {
		return uniLabel;
	}

	public void setUniLabel(JLabel uniLabel) {
		this.uniLabel = uniLabel;
	}

	public JLabel getCatLabel() {
		return catLabel;
	}

	public void setCatLabel(JLabel catLabel) {
		this.catLabel = catLabel;
	}

	public JLabel getCoopeLabel() {
		return coopeLabel;
	}

	public void setCoopeLabel(JLabel coopeLabel) {
		this.coopeLabel = coopeLabel;
	}

	public JLabel getGradeLabel() {
		return gradeLabel;
	}

	public void setGradeLabel(JLabel gradeLabel) {
		this.gradeLabel = gradeLabel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public String[] getSortBy() {
		return sortBy;
	}

	public void setSortBy(String[] sortBy) {
		this.sortBy = sortBy;
	}

	public JComboBox<String> getSortList() {
		return sortList;
	}

	public void setSortList(JComboBox<String> sortList) {
		this.sortList = sortList;
	}

	public String[] getUni() {
		return uni;
	}

	public void setUni(String[] uni) {
		this.uni = uni;
	}

	public JComboBox<String> getUniList() {
		return uniList;
	}

	public void setUniList(JComboBox<String> uniList) {
		this.uniList = uniList;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public JComboBox<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(JComboBox<String> categoryList) {
		this.categoryList = categoryList;
	}

	public String[] getExperiential() {
		return experiential;
	}

	public void setExperiential(String[] experiential) {
		this.experiential = experiential;
	}

	public JComboBox<String> getExperientialList() {
		return experientialList;
	}

	public void setExperientialList(JComboBox<String> experientialList) {
		this.experientialList = experientialList;
	}

	public String[] getGrade() {
		return grade;
	}

	public void setGrade(String[] grade) {
		this.grade = grade;
	}

	public JComboBox<String> getGradeList() {
		return gradeList;
	}

	public void setGradeList(JComboBox<String> gradeList) {
		this.gradeList = gradeList;
	}

	public JButton getCat1() {
		return cat1;
	}

	public void setCat1(JButton cat1) {
		this.cat1 = cat1;
	}

	public JButton getCat2() {
		return cat2;
	}

	public void setCat2(JButton cat2) {
		this.cat2 = cat2;
	}

	public JButton getCat3() {
		return cat3;
	}

	public void setCat3(JButton cat3) {
		this.cat3 = cat3;
	}

	public JButton getCat4() {
		return cat4;
	}

	public void setCat4(JButton cat4) {
		this.cat4 = cat4;
	}

	public JButton getCat5() {
		return cat5;
	}

	public void setCat5(JButton cat5) {
		this.cat5 = cat5;
	}

	public JButton getCat6() {
		return cat6;
	}

	public void setCat6(JButton cat6) {
		this.cat6 = cat6;
	}

	public JButton getCat7() {
		return cat7;
	}

	public void setCat7(JButton cat7) {
		this.cat7 = cat7;
	}

	public JButton getCat8() {
		return cat8;
	}

	public void setCat8(JButton cat8) {
		this.cat8 = cat8;
	}

	public JButton getCat9() {
		return cat9;
	}

	public void setCat9(JButton cat9) {
		this.cat9 = cat9;
	}

	public JButton getCat10() {
		return cat10;
	}

	public void setCat10(JButton cat10) {
		this.cat10 = cat10;
	}

	public JButton getCat11() {
		return cat11;
	}

	public void setCat11(JButton cat11) {
		this.cat11 = cat11;
	}

	public JButton getUni2() {
		return uni2;
	}

	public void setUni2(JButton uni2) {
		this.uni2 = uni2;
	}

	public JButton getUni3() {
		return uni3;
	}

	public void setUni3(JButton uni3) {
		this.uni3 = uni3;
	}

	public JButton getUni4() {
		return uni4;
	}

	public void setUni4(JButton uni4) {
		this.uni4 = uni4;
	}

	public JButton getUni6() {
		return uni6;
	}

	public void setUni6(JButton uni6) {
		this.uni6 = uni6;
	}

	public JButton getUni7() {
		return uni7;
	}

	public void setUni7(JButton uni7) {
		this.uni7 = uni7;
	}

	public JButton getUni8() {
		return uni8;
	}

	public void setUni8(JButton uni8) {
		this.uni8 = uni8;
	}

	public JButton getUni9() {
		return uni9;
	}

	public void setUni9(JButton uni9) {
		this.uni9 = uni9;
	}

	public JButton getUni10() {
		return uni10;
	}

	public void setUni10(JButton uni10) {
		this.uni10 = uni10;
	}

	public JButton getUni12() {
		return uni12;
	}

	public void setUni12(JButton uni12) {
		this.uni12 = uni12;
	}

	public JButton getUni13() {
		return uni13;
	}

	public void setUni13(JButton uni13) {
		this.uni13 = uni13;
	}

	public JButton getUni14() {
		return uni14;
	}

	public void setUni14(JButton uni14) {
		this.uni14 = uni14;
	}

	public JButton getUni15() {
		return uni15;
	}

	public void setUni15(JButton uni15) {
		this.uni15 = uni15;
	}

	public JButton getUni16() {
		return uni16;
	}

	public void setUni16(JButton uni16) {
		this.uni16 = uni16;
	}

	public JButton getUni17() {
		return uni17;
	}

	public void setUni17(JButton uni17) {
		this.uni17 = uni17;
	}

	public JButton getUni18() {
		return uni18;
	}

	public void setUni18(JButton uni18) {
		this.uni18 = uni18;
	}

	public JButton getUni19() {
		return uni19;
	}

	public void setUni19(JButton uni19) {
		this.uni19 = uni19;
	}

	public JButton getUni20() {
		return uni20;
	}

	public void setUni20(JButton uni20) {
		this.uni20 = uni20;
	}

	public JButton getUni21() {
		return uni21;
	}

	public void setUni21(JButton uni21) {
		this.uni21 = uni21;
	}

	public JButton getUni22() {
		return uni22;
	}

	public void setUni22(JButton uni22) {
		this.uni22 = uni22;
	}

	public JButton getUni23() {
		return uni23;
	}

	public void setUni23(JButton uni23) {
		this.uni23 = uni23;
	}
	
	

}
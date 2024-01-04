/*
 * Features want others to notice: 
 * - Combine navigation bar and scholarship selection 
 * - Next button to transition to detailed scholarship information
 * Major Skills: 
 * - GUI design using Swing
 * - Event handling for button actions
 * - Integration of navigation bar and scholarship selection
 * Areas of Concern: 
 * - Wanted to do a combobox of scholarship value, didnt work
 */

package view;

import view.NavigationBarPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ScholarshipsFrame extends JFrame {

    private JComboBox<String> programComboBox;
    private JButton nextButton;

    public ScholarshipsFrame() {
        initializeFrames();
    }

    public void setScholarshipSelectedListener(Consumer<String> listener) {
        nextButton.addActionListener(e -> {
            String selectedScholarship = (String) programComboBox.getSelectedItem();
            listener.accept(selectedScholarship);
        });
    }

    private void initializeFrames() {
        // Frame setup
        setTitle("Scholarships");
        setSize(1440, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Navigation bar initialization
        NavigationBarPanel navigationBarPanel = new NavigationBarPanel();

        // Main content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false); // Ensure transparency for background image

        // Background image setup
        ImageIcon backgroundImage = new ImageIcon("images/background.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        // Panel for combo box and button
        JPanel comboPanel = new JPanel(new GridBagLayout());
        comboPanel.setOpaque(false);

        // GridBagLayout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Program combo box
        programComboBox = new JComboBox<>();	//if the user dosent select a scholarship / program use the link below, that is the home page of the scholarship so its random 
        programComboBox.addItem("Scholarship"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Region=Canada&Province=ON
        programComboBox.addItem("Computer Science"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Computer%20Science&Region=Canada&Province=ON
        programComboBox.addItem("Engineering Science"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Engineering%20Science&Region=Canada&Province=ON
        programComboBox.addItem("Acounting and Finance"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Accounting&Region=Canada&Province=ON
        programComboBox.addItem("Marketing Research"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Marketing%20Research&Region=Canada&Province=ON
        programComboBox.addItem("Education, General"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Education,%20General&Region=Canada&Province=ON
        programComboBox.addItem("Ethics"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Ethics&Region=Canada&Province=ON
        programComboBox.addItem("Mathematics, General"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Mathematics,%20General&Region=Canada&Province=ON
        programComboBox.addItem("Medicine MD"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=Medicine%20(MD)&Region=Canada&Province=ON
        programComboBox.addItem("History General"); //https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=History,%20General&Region=Canada&Province=ON
        programComboBox.addItem("Acting");
        programComboBox.addItem("Sociology");
        programComboBox.addItem("Zoology/Animal Biology");
        programComboBox.addItem("Advertising");
        programComboBox.addItem("Architectural Engineering");
        programComboBox.addItem("Astronomy");
        programComboBox.addItem("Biochemistry");
        programComboBox.addItem("Chemical Engineering");
        programComboBox.addItem("Electrician");
        programComboBox.addItem("German Studies");
        programComboBox.addItem("Insurance");
        programComboBox.addItem("Music");

        gbc.gridx = 0;
        gbc.gridy = 0;
        comboPanel.add(programComboBox, gbc);

        // Next button 
        nextButton = new JButton(new ImageIcon("images/next.png"));
        nextButton.setBorderPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setFocusPainted(false);
        nextButton.setOpaque(false);
        nextButton.addActionListener(e -> {
            String selectedScholarship = (String) programComboBox.getSelectedItem();

            ScholarshipsFrame2 secondFrame = new ScholarshipsFrame2(selectedScholarship);
            secondFrame.setVisible(true);
            dispose(); // Close the first frame
        });

        gbc.gridx = 1;
        comboPanel.add(nextButton, gbc);

        //seemed empty added this  
        JLabel titleLabel = new JLabel("Get Instant Information Of Your Desired Scholarships");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints centerGbc = new GridBagConstraints();
        centerGbc.gridx = 0;
        centerGbc.gridy = 0;
        centerGbc.weightx = 1.0;
        centerGbc.weighty = 1.0;
        centerGbc.anchor = GridBagConstraints.CENTER;

        // Center panel setup 
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(titleLabel, centerGbc);

        // Constraints for placing the center panel in the combo panel
        GridBagConstraints comboGbc = new GridBagConstraints();
        comboGbc.gridx = 0;
        comboGbc.gridy = 1;
        comboGbc.insets = new Insets(20, 0, 0, 0);

        comboPanel.add(centerPanel, comboGbc);

        // Add the combo panel to the background label
        backgroundLabel.add(comboPanel, BorderLayout.CENTER);

        // Add components to content panel
        contentPanel.add(backgroundLabel, BorderLayout.CENTER);
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(navigationBarPanel, BorderLayout.WEST);
        backgroundLabel.add(topPanel, BorderLayout.NORTH);

        // Set the content panel
        setContentPane(contentPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScholarshipsFrame frame = new ScholarshipsFrame();
            frame.setVisible(true);
        });
    }
}

package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import view.NavigationBarPanel;

/*
 * Features want others to notice: 
 * - Displays scholarship information based on selected scholarship
 * - Utilizes Jsoup for web scraping to gather scholarship details
 * Major Skills: 
 * - Web scraping using Jsoup
 * - Dynamic rendering of scholarship details in JLabels
 * - Panel layout and display based on retrieved information
 * Areas of Concern: 
 * - Field of study not working properly 
 * - Should have added something to deal with a scholarship that does not exist 
 */


public class ScholarshipsFrame2 extends JFrame {
    public ScholarshipsFrame2(String selectedScholarship) {
        setTitle("Scholarship Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1440, 900);
        setLocationRelativeTo(null);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("images/background.jpg"));
        setContentPane(backgroundLabel);

        JPanel mainPanel = new JPanel(new BorderLayout()) {
            private Image backgroundImage = new ImageIcon("images/background.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        mainPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        // Add the NavigationBarPanel from the first GUI
        topPanel.add(new NavigationBarPanel(), BorderLayout.WEST);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel scholarshipInfoPanel = new JPanel();
        scholarshipInfoPanel.setLayout(new BoxLayout(scholarshipInfoPanel, BoxLayout.Y_AXIS));
        scholarshipInfoPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(scholarshipInfoPanel);
        scrollPane.setPreferredSize(new Dimension(1440, 900));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.add(mainPanel, BorderLayout.CENTER);

        fetchScholarshipInfo(selectedScholarship, scholarshipInfoPanel);
    }

    private void fetchScholarshipInfo(String selectedScholarship, JPanel scholarshipInfoPanel) {
        String url;

        if (selectedScholarship.equals("Scholarship")) {
            // Set the default URL if "Scholarship" is selected
            url = "https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Region=Canada&Province=ON";
        } else {
            // Set the URL based on the selected scholarship
            url = "https://www.scholarshipscanada.com/Scholarships/ScholarshipSearch.aspx?type=ScholarshipName&s=&Field=" +
                    selectedScholarship.replace(" ", "%20") + "&Region=Canada&Province=ON";
        }

        try {
            Document doc = Jsoup.connect(url).get();
            Elements scholarshipEntries = doc.select(".Table-Standard-AwardName.Table-Scholarship-AwardName");

            
            for (Element entry : scholarshipEntries) {
                Elements scholarshipNameElement = entry.select("a.bold");
                String scholarshipName = (scholarshipNameElement != null) ? scholarshipNameElement.text() : "";

                Elements scholarshipValueElement = entry.nextElementSibling().select(".Table-Standard-Amount.Table-Scholarship-Amount span");
                String scholarshipValue = (scholarshipValueElement != null) ? scholarshipValueElement.text() : "";

                Elements schoolElement = entry.select("span:contains(School) + a");
                String school = (schoolElement != null) ? schoolElement.text() : "";

                Elements fieldOfStudyElement = entry.select("span:contains(Field of Study) + b");
                String fieldOfStudy = (fieldOfStudyElement != null) ? fieldOfStudyElement.text() : "";

                //for the informationt that is displayed 
                StringBuilder displayInfo = new StringBuilder();
                displayInfo.append("<html>");
                displayInfo.append("<head>");
                displayInfo.append("<style>body { font-size: 14px; }</style>"); // Set the initial font size
                displayInfo.append("</head>");
                displayInfo.append("<body>");
                displayInfo.append("<b>Scholarship Name:</b> ").append(scholarshipName).append("<br>");
                displayInfo.append("<b>School:</b> ").append(school).append("<br>");
                displayInfo.append("<b>Field of Study:</b> ").append(fieldOfStudy).append("<br>");
                displayInfo.append("<b>Scholarship Value:</b> ").append(scholarshipValue).append("<br><br>");
                displayInfo.append("</body>");
                displayInfo.append("</html>");

                JLabel scholarshipInfoLabel = new JLabel(displayInfo.toString());
                scholarshipInfoLabel.setPreferredSize(new Dimension(1440, 900)); // Set preferred label size

                scholarshipInfoPanel.add(scholarshipInfoLabel);
            }

            if (scholarshipEntries.isEmpty()) {
                JLabel noScholarshipLabel = new JLabel("No matching scholarships found.");
                scholarshipInfoPanel.add(noScholarshipLabel);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JLabel errorLabel = new JLabel("Error fetching scholarship information. Please try again.");
            scholarshipInfoPanel.add(errorLabel);
        }
    }
}
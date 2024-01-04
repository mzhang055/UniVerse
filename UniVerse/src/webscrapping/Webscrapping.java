/*
Name: Daniel Zheng
Date: Dec 7
Description: This class creates a csv file storing all the program informations
Major Skills:
Web scraping from only the valid programs. This way it's not just a trail and error.
Code is much more efficient
Areas of Concern: This program adds commas in the csv file so I just needed to Find and Replace all the commas with nothing

*/

package webscrapping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;

public class Webscrapping {
	
	private static String ArchitectureLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=architectur&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String BiologicalSciencesLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=biological-sciences&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String BusinessStudiesLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=bus-studies&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String ComputerScienceLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=computer-science-1&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String CreativeArtsAndDesignLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=creative-arts-design&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String EngineeringLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=engineering-1&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String HealthSciencesLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=health-sciences&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String MathematicsLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=mathematics-1&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String MediaLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=media-comm-studies&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String PhysicalSciencesLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=physical-sciences&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	private static String SocialSciencesLink = "https://www.ontariouniversitiesinfo.ca/programs/search?sort=university&search=&advanced=1&a_univ=&a_category=social-sciences&a_subject=&a_location=&a_coop=&a_graderange=&a_lang=22";
	
	private static String[] categoryLinks = new String[] { ArchitectureLink, BiologicalSciencesLink, BusinessStudiesLink, ComputerScienceLink, CreativeArtsAndDesignLink,
			EngineeringLink, HealthSciencesLink, MathematicsLink, MediaLink, PhysicalSciencesLink, SocialSciencesLink };
	
	private static ArrayList<String> ArchitecturePrograms = new ArrayList<String>();
	private static ArrayList<String> BiologicalSciencesPrograms = new ArrayList<String>();
	private static ArrayList<String> BusinessStudiesPrograms = new ArrayList<String>();
	private static ArrayList<String> ComputerSciencePrograms = new ArrayList<String>();
	private static ArrayList<String> CreativeArtsAndDesignPrograms = new ArrayList<String>();
	private static ArrayList<String> EngineeringPrograms = new ArrayList<String>();
	private static ArrayList<String> HealthSciencesPrograms = new ArrayList<String>();
	private static ArrayList<String> MathematicsPrograms = new ArrayList<String>();
	private static ArrayList<String> MediaPrograms = new ArrayList<String>();
	private static ArrayList<String> PhysicalSciencesPrograms = new ArrayList<String>();
	private static ArrayList<String> SocialSciencesPrograms = new ArrayList<String>();
	
	private static ArrayList<String>[] categoryPrograms = new ArrayList[] {ArchitecturePrograms, BiologicalSciencesPrograms, BusinessStudiesPrograms, ComputerSciencePrograms, CreativeArtsAndDesignPrograms,
			EngineeringPrograms, HealthSciencesPrograms, MathematicsPrograms, MediaPrograms, PhysicalSciencesPrograms, SocialSciencesPrograms};
	
	public static void main(String[] args) throws IOException, HttpStatusException {
		
        String csvFilePath = "categories.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {
        	
        	// Write the CSV header
            csvWriter.writeNext(new String[] { "Program", "Category", "University", "Grade Range", "Co-op Available", "Prerequisites" });
        	
            //Adds all valid programs into an array relating to each category
            for (int x = 0; x < 11; x++) {
            	
            	String url = categoryLinks[x];
            
	            Document doc = Jsoup.connect(url).get();
	            Elements programElements = doc.select(".result-program"); // Select the elements containing program information
	
	            for (Element program : programElements) {
	                String dataProgram = program.attr("data-program"); // Get the value of data-program attribute
	                //System.out.println(dataProgram);
	                categoryPrograms[x].add(dataProgram);
	                
	            }
            
            }
            
            //Goes through each category array 
            for (int x = 0; x < 11; x++) {
            	
            	for (String programCode : categoryPrograms[x]) {
            
		            String url = "https://www.ontariouniversitiesinfo.ca/programs/" + programCode;
		            Document doc = Jsoup.connect(url).get();
		
		            List<String> programData = new ArrayList<>();
		
		            // Extract program title
		            String pageTitle = doc.title();
		            if (!pageTitle.equals("OUInfo")) {
		                programData.add(pageTitle);
		            }
		
		            Elements dataTitleList = doc.select("dt");
		            Elements dataList = doc.select("dd");
		            
		            //Adds the category section
		            if (x == 0)
		            	programData.add("Architecture");
		            else if (x == 1)
		            	programData.add("Biological Sciences");
		            else if (x == 2)
		            	programData.add("Business Studies");
		            else if (x == 3)
		            	programData.add("Computer Science");
		            else if (x == 4)
		            	programData.add("Creative Arts And Design");
		            else if (x == 5)
		            	programData.add("Engineering");
		            else if (x == 6)
		            	programData.add("Health Sciences");
		            else if (x == 7)
		            	programData.add("Mathematics");
		            else if (x == 8)
		            	programData.add("Media");
		            else if (x == 9)
		            	programData.add("Physical Sciences");
		            else if (x == 10)
		            	programData.add("Social Sciences");
		
		            //Adds the rest of the information on the website to the csv file
		            for (int index = 0; index < dataTitleList.size(); index++) {
		                String title = dataTitleList.get(index).toString();
		
		                if (title.contains("title")) {
		                    programData.add(dataTitleList.get(index).text());
		                }
		
		                if (title.contains("University")) {
		                    programData.add(dataList.get(index).text());
		                }
		
		                if (title.contains("Grade Range")) {
		                    programData.add(dataList.get(index).text());
		                }
		                
		                if (title.contains("Experiential Learning")) {
		                    programData.add(dataList.get(index).text());
		                }
		            }
		
		            // Extract prerequisites
		            Elements prerequisitesElements = doc.select("h4:contains(Prerequisites)");
		            for (Element prerequisitesElement : prerequisitesElements) {
		                String prerequisitesContent = "";
		                Element divAfterPrerequisites = prerequisitesElement.nextElementSibling();
		                while (divAfterPrerequisites != null && !divAfterPrerequisites.tagName().equals("h4")) {
		                    prerequisitesContent += divAfterPrerequisites.text() + " ";
		                    divAfterPrerequisites = divAfterPrerequisites.nextElementSibling();
		                }
		                programData.add(prerequisitesContent.trim());
		            }
		
		            csvWriter.writeNext(programData.toArray(new String[0]));
            	}
            	
            }
            
        } catch (HttpStatusException e1) {
        } catch (IOException e) {}
        
	}
	
}
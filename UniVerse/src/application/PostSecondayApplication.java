/* Names: Michelle (20%), Samiksha(20%), Daniel(20%), Johnny(20%), Jay(20%)
 * Date: Decemeber 15 2023
 * Course Code: ICS4U1
 * Title: UniVerse
 * 
 * DESCRIPTION: UniVerse is a post secondary application aimed to help highschool students choose 
 * their path for university. Our application accommodates multiple users/accounts and includes many unique 
 * tools, such as an interest survey that matches users to 3 potential programs of interest, an interactive 
 * map tool to view the user's location from universities across ontario, view your grades, browse programs, 
 * and browse scholarships. 
 * 
 * FEATURES:
 * Interactive Map - Samiksha: 
 * -  Universities sorted by a specific radius when choice is picked 
 * - University icons are shown with each university location 
 * - General information of each university is displayed when clicked on university icon 
 * - Distance from user’s location, number of programs, and website of each university can be accessed 
 * - Users can bookmark up to 5 universities and can unbookmark universities as needed 
 * - Help button for interactive map instructions 
 * 
 * User Registration/Login System - Michelle:
 * - Users can reset their password on the user profile frame
 * - User's most recent survey results are saved and store on the mySQL database. When the user
 * signs into their account again, these results will be updated and displayed on the homeframe
 * - User's bookmarks on the interactive map are saved and updated if the user decides to bookmark
 * a new unviersity or unbookmark it. This data is stored in the mySQL database so when the user signs in again,
 * their bookmarks from their previous session is saved.
 * - If a user tries to register an account but their desired username is already in use, they will receive an error
 * message prompting them to choose another username
 * - Validation on user input (checks if passwords at at least 8 characters, all required fields are filled)
 * 
 *  Survey Feature - Daniel:
 *  - This survey is for those who are unsure of what program they want to go into
 *  20 statements will be shown, one by one, and the user will need to answer how much they relate to it on a scale of 1-6
 *  - Each question will be related to a category
 *  - When the user answers how much they relate to the question, it will change the priority
 *  - Depending on the number the user presses, it will either decrease a little or increase a lot
 *  - After the user finishes the survey, they will be brought to a result frame
 *  - This result frame will display the highest priority program
 *  - The user can then select the category which will bring them to a new frame to look through all the programs
 *  
 *  Search and Sort Feature (Programs) - Johnny:
 *  - This frame allows the user to search through over 2000 programs
 *  This is done with the help of web scraping
 *  The user will be able to organize based on university, category, grade range and coop availibility
 *  If the user already has a program in mind, they also have the ability to search it up
 * 
 * Browse Scholarships - Jay:
 * - This frame allows the user to browse various scholarships based on a field of study 
 * - Webscrapping from Scholarships Canada to get the data
 * - This displays the scholarship name, school it is from, field of study, and the scholarship value
 * 
 * 
 * MAJOR SKILLS:
 * - web scrapping using JSoup library on the Ontario University Info and Scholarships Canada website
 * - Used opencsv to read csv files
 * - Used API - JXMapViewer2
 * - Read in general information, university images and number of programs from each university into the program
 * - Login system to authenticate users using JDBC and MySQL database. 
 * 		- This was administrated on phpMyAdmin to host the database server and was used to run queries 
 * 		- XAMPP was used to test the database locally on my computer

 * 
 * 
 * AREAS OF CONCERN:
 * - the database that stores all the user's info and controls the login system is hosted locally on michelles computer
 * but can be configured to accessed on multiple devices if needed
 * 
 * 
 */

package application;

import view.WelcomeFrame;

public class PostSecondayApplication {
	
	public static void main(String[] args) {
		new WelcomeFrame();

	}

}

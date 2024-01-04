/*
Name: Daniel Zheng
Date: Dec 10
Description: This class will put all the program information into one giant array so the program can access the information easier
Major Skills: Not really any much major skills
Areas of Concern: The delimiter was looking for commas so I had to remove them from the csv file

*/

package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Program;

public class ProgramFileInput {
	
	private Program[] programArray = new Program[2064];

	public ProgramFileInput() {
		
		try {
			
			//Creates the scanner
			Scanner inputFile = new Scanner(new File("data/program.csv"));
			
			//Lets the code know how you want to space your element
			inputFile.useDelimiter(",|\\n");
			
			//Creates a new line
			inputFile.nextLine();
			
			//Loops through every program on the csv file
			for (int index = 0; index < programArray.length; index++) {
				
				//Gathers the information of each program and stores it in a variable
				String programName = inputFile.next();
				String category = inputFile.next();
				String universityName = inputFile.next();
				String gradeRange = inputFile.next();
				String coopAvailable = inputFile.next();
				String prerequisites = inputFile.next();
				
				//Adds all the attributes into an array
				programArray[index] = new Program(programName, category, universityName, gradeRange, coopAvailable, prerequisites);
				
			}
			
			//Closes the file
			inputFile.close();
			
			
		} catch (FileNotFoundException e) {
			
			//Prints "File Error" if something does not work
			System.out.println("File Error");
			
		}
		
	}

	public Program[] getProgramArray() {
		return programArray;
	}

	public void setProgramArray(Program[] programArray) {
		this.programArray = programArray;
	}
	
	

}
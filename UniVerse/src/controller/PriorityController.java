/* 
Name: Daniel Zheng
Date: Dec 4
Description: This will control the priority of each program. The highest priority program will be displayed.

*/

package controller;

import model.Category;
import model.CategoryList;

public class PriorityController {
	
	//All the categories
	private Category Architecture = new Category("Architecture", 50);
	private Category BiologicalSciences = new Category("Biological Sciences", 50);
	private Category BusinessStudies = new Category("Business Studies", 50);
	private Category ComputerScience = new Category("Computer Science", 50);
	private Category CreativeArtsAndDesign = new Category("Creative Arts And Design", 50);
	private Category Engineering = new Category("Engineering", 50);
	private Category HealthSciences = new Category("Health Sciences", 50);
	private Category Mathematics = new Category("Mathematics", 50);
	private Category Media = new Category("Media", 50);
	private Category PhysicalSciences = new Category("Physical Sciences", 50);
	private Category SocialSciences = new Category("Social Sciences", 50);

	//Creates the list that stores all the categories
	private CategoryList list;
	
	//Constructor
	public PriorityController() {
		
		list = new CategoryList();
		
		addToList();
		
	}

	//Setters and getters
	public CategoryList getList() {
		return list;
	}

	public void setList(CategoryList list) {
		this.list = list;
	}

	//Adds all the programs into an ArrayList
	private void addToList() {
		
		//Adds all the categories onto an ArrayList so we're able to compare them easily
		list.getCategoryList().add(Architecture);
		list.getCategoryList().add(BiologicalSciences);
		list.getCategoryList().add(BusinessStudies);
		list.getCategoryList().add(ComputerScience);
		list.getCategoryList().add(CreativeArtsAndDesign);
		list.getCategoryList().add(Engineering);
		list.getCategoryList().add(HealthSciences);
		list.getCategoryList().add(Mathematics);
		list.getCategoryList().add(Media);
		list.getCategoryList().add(PhysicalSciences);
		list.getCategoryList().add(SocialSciences);
		
	}
	
	//Changes priority using the name instead of the index in the ArrayList
	public void changePriority(String categoryName, int newPriority) {
		
		//Goes through the entire list of categories
        for (Category category : list.getCategoryList()) {
        	
        	//When it finds the category that you would like to change the priority of 
            if (category.getCategoryName().equals(categoryName)) {
            	
            	int oldPriority = category.getPriority();
            	
            	//It will set the new priority to the new desired value
                category.setPriority(oldPriority += newPriority);
                
                //Breaks so once it finds the category, it won't keep running
                break; 
                
            }
            
        }
        
    }
	
}
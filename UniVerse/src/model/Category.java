/*
Name: Daniel Zheng
Date: Dec 4
Description: This class is used to create relevant categories; each category will have its name as well as a priority value

*/

package model;

public class Category {
	
	//Attributes/Fields
	private String categoryName;
	private int priority;
	
	//Constructor method
	public Category(String categoryName, int priority) {
		super();
		this.categoryName = categoryName;
		this.priority = priority;
	}

	//Getters and setters
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	//toString method
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", priority=" + priority + "]";
	}

}

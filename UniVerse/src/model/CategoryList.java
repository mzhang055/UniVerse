/*
Name: Daniel Zheng
Date: Dec 4
Description: 
Links:
Sorting Categories - https://stackoverflow.com/questions/5932720/how-to-sort-an-attribute-of-an-object-using-collections

*/

package model;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryList {
	
	//Attributes
	private ArrayList<Category> CategoryList;

	//Constructor
	public CategoryList() {
		super();
		CategoryList = new ArrayList<Category>();
	}

	//Getters and setters
	public ArrayList<Category> getCategoryList() {
		return CategoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		CategoryList = categoryList;
	}
	
	//Method called to sort the categories based on their priorities
	public void sortPriority() {
		
		Collections.sort(CategoryList, new CategoryComparator());
		
	}

	//Idk why but when I call the get method in the Test class it doesn't work
	public Category get(int i) {
		
		Category category = CategoryList.get(i);
		return category;
		
	}

}

//Compares the priorities and moves the higher ones to the top
class CategoryComparator implements java.util.Comparator<Category> {
	
    @Override
    public int compare(Category a, Category b) {
    	
        return b.getPriority() - a.getPriority();
        
    }
    
}

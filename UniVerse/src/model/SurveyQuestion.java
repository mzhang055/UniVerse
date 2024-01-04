/*
Name: Daniel Zheng
Date: Dec 5
Description: This class will be used to create the question, and increase the priority of certain categories

*/

package model;

import java.util.ArrayList;

public class SurveyQuestion {
	
	//Attributes
	private String questionPrompt;
	private String[] relatedCategories;
	
	//Constructor
	public SurveyQuestion(String questionPrompt, String[] relatedCategories) {
		super();
		this.questionPrompt = questionPrompt;
		this.relatedCategories = relatedCategories;
	}

	//Getters and setters
	public String getQuestionPrompt() {
		return questionPrompt;
	}

	public void setQuestionPrompt(String questionPrompt) {
		this.questionPrompt = questionPrompt;
	}

	public String[] getRelatedCategories() {
		return relatedCategories;
	}

	public void setRelatedCategories(String[] relatedCategories) {
		this.relatedCategories = relatedCategories;
	}

	//toString method
	@Override
	public String toString() {
		return "SurveyQuestion [questionPrompt=" + questionPrompt + ", relatedCategories=" + relatedCategories + "]";
	}
	
}

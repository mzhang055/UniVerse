/*
Name: Daniel Zheng
Date: Dec 5
Description: This controller is used to create the questions and it's related categories

*/

package controller;

import java.util.ArrayList;
import java.util.Stack;

import model.SurveyQuestion;

public class QuestionController {
	
	//Creates an ArrayList to store all the questions
	private ArrayList<SurveyQuestion> questions;
	//Creates stacks of previous questions and priorities, in case the user presses the back button
	private Stack<SurveyQuestion> usedQuestions;
	private Stack<Integer> previousPriorities;
	
	//All the related categories of the question
	private String [] categories1 = {"Social Sciences"};
	private String [] categories2 = {"Engineering", "Architecture"};
	private String [] categories3 = {"Creative Arts And Design"};
	private String [] categories4 = {"Health Sciences"};
	private String [] categories5 = {"Biological Sciences", "Physical Sciences"};
	private String [] categories6 = {"Business Studies"};
	private String [] categories7 = {"Mathematics"};
	private String [] categories8 = {"Computer Science"};
	private String [] categories9 = {"Physical Sciences"};
	private String [] categories10 = {"Media"};
	private String [] categories11 = {"Social Sciences"};
	private String [] categories12 = {"Business Studies"};
	private String [] categories13 = {"Computer Science"};
	private String [] categories14 = {"Creative Arts And Design"};
	private String [] categories15 = {"Engineering"};
	private String [] categories16 = {"Health Sciences"};
	private String [] categories17 = {"Biological Sciences"};
	private String [] categories18 = {"Architecture"};
	private String [] categories19 = {"Media"};
	private String [] categories20 = {"Mathematics"};
	
	//The questions that are going to be displayed
	private SurveyQuestion question1 = new SurveyQuestion("My friends are able to talk to me about their personal problems", categories1);
	private SurveyQuestion question2 = new SurveyQuestion("I'm interested in how bridges work", categories2);
	private SurveyQuestion question3 = new SurveyQuestion("I enjoy drawing", categories3);
	private SurveyQuestion question4 = new SurveyQuestion("I want to help people in the future", categories4);
	private SurveyQuestion question5 = new SurveyQuestion("Animals have a soft spot in my heart", categories5);
	private SurveyQuestion question6 = new SurveyQuestion("I'm the type of person to create a lemonade stand", categories6);
	private SurveyQuestion question7 = new SurveyQuestion("I enjoy solving math problems", categories7);
	private SurveyQuestion question8 = new SurveyQuestion("I want to create my own game or software one day", categories8);
	private SurveyQuestion question9 = new SurveyQuestion("I am interested in nature and our planet", categories9);
	private SurveyQuestion question10 = new SurveyQuestion("I want to create my own movie one day", categories10);
	private SurveyQuestion question11 = new SurveyQuestion("I enjoy teaching my friends about things they lack information about", categories11);
	private SurveyQuestion question12 = new SurveyQuestion("I want to start up my own shop or restaurant", categories12);
	private SurveyQuestion question13 = new SurveyQuestion("I want to help design a new IOS for apple", categories13);
	private SurveyQuestion question14 = new SurveyQuestion("I want to act in a popular movie ", categories14);
	private SurveyQuestion question15 = new SurveyQuestion("I built my own PC using individual parts", categories15);
	private SurveyQuestion question16 = new SurveyQuestion("I find surgery a very cool concept", categories16);
	private SurveyQuestion question17 = new SurveyQuestion("Cell division and the cause of cancer is interesting to me", categories17);
	private SurveyQuestion question18 = new SurveyQuestion("I believe designing something is more important than building it", categories18);
	private SurveyQuestion question19 = new SurveyQuestion("I like taking pictures of everything", categories19);
	private SurveyQuestion question20 = new SurveyQuestion("I want to know where the formulas for shapes come from", categories20);

	public QuestionController() {
		super();
		questions = new ArrayList<SurveyQuestion>();
		usedQuestions = new Stack<SurveyQuestion>();
		previousPriorities = new Stack<Integer>();
		
		//Adds the questions into the question ArrayList
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		questions.add(question4);
		questions.add(question5);
		questions.add(question6);
		questions.add(question7);
		questions.add(question8);
		questions.add(question9);
		questions.add(question10);
		questions.add(question11);
		questions.add(question12);
		questions.add(question13);
		questions.add(question14);
		questions.add(question15);
		questions.add(question16);
		questions.add(question17);
		questions.add(question18);
		questions.add(question19);
		questions.add(question20);
		
	}

	//Getters and setters
	public String[] getCategories1() {
		return categories1;
	}

	public void setCategories1(String[] categories1) {
		this.categories1 = categories1;
	}

	public ArrayList<SurveyQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<SurveyQuestion> questions) {
		this.questions = questions;
	}

	public Stack<SurveyQuestion> getUsedQuestions() {
		return usedQuestions;
	}

	public void setUsedQuestions(Stack<SurveyQuestion> usedQuestions) {
		this.usedQuestions = usedQuestions;
	}

	public Stack<Integer> getPreviousPriorities() {
		return previousPriorities;
	}

	public void setPreviousPriorities(Stack<Integer> previousPriorities) {
		this.previousPriorities = previousPriorities;
	}
	
}
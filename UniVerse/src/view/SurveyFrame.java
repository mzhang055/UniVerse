/*
Name: Daniel Zheng
Date: Dec 5
Description: This frame will store all the question panels as well as the navigation bar

*/

package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.QuestionController;

public class SurveyFrame extends JFrame {
	
	//Creates a background
	private JLabel backgroundLabel;
	
	//Creates the JPanels 
	private NavigationBarPanel navPanel;
	private QuestionPanel questionPanel;
	private SurveyResultPanel resultPanel;
	
	
	//Constructor
	public SurveyFrame() {
		
		//Creates the background label
		backgroundLabel = new JLabel(new ImageIcon("images/Background.png"));
		backgroundLabel.setLayout(null);
		backgroundLabel.setBounds(0, 0, 1440, 900);
		add(backgroundLabel);
		
		//Sets the basics of the frame
		setTitle("Survey");
		setSize(1440, 900);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates the navigation JPanel
		navPanel = new NavigationBarPanel();
		navPanel.setBounds(0, 0, 1440, 115);
		backgroundLabel.add(navPanel);
		
		//Creates the question JPanel
		questionPanel = new QuestionPanel();
		questionPanel.setBounds(0, 115, QuestionPanel.QUESTION_SIZE_X, QuestionPanel.QUESTION_SIZE_Y);
		backgroundLabel.add(questionPanel);
		
		//Creates the results JPanel but doesn't add it to the frame yet
		resultPanel = new SurveyResultPanel();
		resultPanel.setBounds(0, 115, QuestionPanel.QUESTION_SIZE_X, QuestionPanel.QUESTION_SIZE_Y);
        
        setVisible(true);
		
	}


	public JLabel getBackgroundLabel() {
		return backgroundLabel;
	}


	public void setBackgroundLabel(JLabel backgroundLabel) {
		this.backgroundLabel = backgroundLabel;
	}


	public NavigationBarPanel getNavPanel() {
		return navPanel;
	}


	public void setNavPanel(NavigationBarPanel navPanel) {
		this.navPanel = navPanel;
	}


	public QuestionPanel getQuestionPanel() {
		return questionPanel;
	}


	public void setQuestionPanel(QuestionPanel questionPanel) {
		this.questionPanel = questionPanel;
	}


	public SurveyResultPanel getResultPanel() {
		return resultPanel;
	}


	public void setResultPanel(SurveyResultPanel resultPanel) {
		this.resultPanel = resultPanel;
	}
	
	

}
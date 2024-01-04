/*
Name: Daniel Zheng
Date: Dec 9
Description: This frame is in charge of everything

*/

package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import view.SearchAndSortFrame;
import view.SurveyFrame;

public class SurveyController implements ActionListener {
	
	public static SurveyFrame surveyFrame;
	public static QuestionController questionController;
	public static PriorityController priorityController;
	public static ProgramFileInput fileInput;
	public static SearchAndSortFrame searchFrame;
	
	public SurveyController() {
		
		questionController = new QuestionController();
		priorityController = new PriorityController();
		fileInput = new ProgramFileInput();
		surveyFrame = new SurveyFrame();
		
		surveyFrame.getQuestionPanel().getButton1().addActionListener(this);
		surveyFrame.getQuestionPanel().getButton2().addActionListener(this);
		surveyFrame.getQuestionPanel().getButton3().addActionListener(this);
		surveyFrame.getQuestionPanel().getButton4().addActionListener(this);
		surveyFrame.getQuestionPanel().getButton5().addActionListener(this);
		surveyFrame.getQuestionPanel().getButton6().addActionListener(this);
		surveyFrame.getQuestionPanel().getBackButton().addActionListener(this);
		surveyFrame.getQuestionPanel().getSkipButton().addActionListener(this);
		surveyFrame.getResultPanel().getChoice1().addActionListener(this);
		surveyFrame.getResultPanel().getChoice2().addActionListener(this);
		surveyFrame.getResultPanel().getChoice3().addActionListener(this);
		surveyFrame.getResultPanel().getFindMore().addActionListener(this);
		
		priorityController.getList().sortPriority();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == surveyFrame.getResultPanel().getFindMore()) {
			
			surveyFrame.setVisible(false);
			
			if (searchFrame == null)
				searchFrame = new SearchAndSortFrame();
			else
				searchFrame.setVisible(true);
			
		}
		
		if (e.getSource() == surveyFrame.getResultPanel().getChoice3()) {
			
			surveyFrame.setVisible(false);
			
			if (searchFrame == null)
				searchFrame = new SearchAndSortFrame();
			else
				searchFrame.setVisible(true);;
			
			searchFrame.getPanel().removeAll();
			searchFrame.getJLabelArray().removeAll(searchFrame.getJLabelArray());
			searchFrame.getPanel().setPreferredSize(new Dimension(1500, 9000));
			
			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().equals(priorityController.getList().get(2).getCategoryName())) {

					searchFrame.getJLabelArray().add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
				
			}
			
			int spacing = 150;
			
			for (int x = 0; x < searchFrame.getJLabelArray().size(); x++) {

				JLabel jlabel = searchFrame.getJLabelArray().get(x);
				jlabel.setBounds(0, 0 + x * spacing, 1500, 150);
				searchFrame.getPanel().add(jlabel);
			}
			searchFrame.repaint();
			searchFrame.revalidate();
			
		}
			
		
		
		if (e.getSource() == surveyFrame.getResultPanel().getChoice2()) {
			
			surveyFrame.setVisible(false);
			
			if (searchFrame == null)
				searchFrame = new SearchAndSortFrame();
			else
				searchFrame.setVisible(true);
			
			searchFrame.getPanel().removeAll();
			searchFrame.getJLabelArray().removeAll(searchFrame.getJLabelArray());
			searchFrame.getPanel().setPreferredSize(new Dimension(1500, 9000));
			
			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().equals(priorityController.getList().get(1).getCategoryName())) {

					searchFrame.getJLabelArray().add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
				
			}
			
			int spacing = 150;
			
			for (int x = 0; x < searchFrame.getJLabelArray().size(); x++) {

				JLabel jlabel = searchFrame.getJLabelArray().get(x);
				jlabel.setBounds(0, 0 + x * spacing, 1500, 150);
				searchFrame.getPanel().add(jlabel);
			}
			searchFrame.repaint();
			searchFrame.revalidate();
			
		}
		
		if (e.getSource() == surveyFrame.getResultPanel().getChoice1()) {
			
			surveyFrame.setVisible(false);
			
			if (searchFrame == null)
				searchFrame = new SearchAndSortFrame();
			else
				searchFrame.setVisible(true);
		
			searchFrame.getPanel().removeAll();
			searchFrame.getJLabelArray().removeAll(searchFrame.getJLabelArray());
			searchFrame.getPanel().setPreferredSize(new Dimension(1500, 9000));
			
			for (int i = 0; i < 2064; i++) {

				if (fileInput.getProgramArray()[i].getCategory().equals(priorityController.getList().get(0).getCategoryName())) {

					searchFrame.getJLabelArray().add(new JLabel(String.format("<html><p body style='text-align:left'>%s</p></html>\"",
							fileInput.getProgramArray()[i].toString())));
				}
				
			}
			
			int spacing = 150;
			
			for (int x = 0; x < searchFrame.getJLabelArray().size(); x++) {

				JLabel jlabel = searchFrame.getJLabelArray().get(x);
				jlabel.setBounds(0, 0 + x * spacing, 1500, 150);
				searchFrame.getPanel().add(jlabel);
			}
			searchFrame.repaint();
			searchFrame.revalidate();
			
		}
		
		
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getButton1()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, -3);
			questionController.getPreviousPriorities().add(3);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
			
		if (e.getSource() == surveyFrame.getQuestionPanel().getButton2()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, -2);
			questionController.getPreviousPriorities().add(2);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getButton3()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, -1);
			questionController.getPreviousPriorities().add(1);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getButton4()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, 1);
			questionController.getPreviousPriorities().add(-1);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getButton5()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, 2);
			questionController.getPreviousPriorities().add(-2);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getButton6()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, 3);
			questionController.getPreviousPriorities().add(-3);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getSkipButton()) {
			
			surveyFrame.getQuestionPanel().getBackButton().setEnabled(true);
			questionController.getUsedQuestions().add(questionController.getQuestions().get(0));
			questionController.getPreviousPriorities().add(0);
			questionController.getQuestions().remove(0);
			if (questionController.getQuestions().size() == 0) {
				
				surveyFrame.getBackgroundLabel().remove(surveyFrame.getQuestionPanel());
				priorityController.getList().sortPriority();
				surveyFrame.getResultPanel().getChoiceLabel1().setText(priorityController.getList().get(0).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel2().setText(priorityController.getList().get(1).getCategoryName());
				surveyFrame.getResultPanel().getChoiceLabel3().setText(priorityController.getList().get(2).getCategoryName());
				surveyFrame.getBackgroundLabel().add(surveyFrame.getResultPanel());
				surveyFrame.revalidate();
				surveyFrame.repaint();
				
			}
			else {
				surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
				surveyFrame.getQuestionPanel().add(surveyFrame.getQuestionPanel().getBackButton());
				surveyFrame.getQuestionPanel().revalidate();
				surveyFrame.getQuestionPanel().repaint();
			}
			
		}
		
		if (e.getSource() == surveyFrame.getQuestionPanel().getBackButton()) {
			
			
			questionController.getQuestions().add(0, questionController.getUsedQuestions().pop());
			surveyFrame.getQuestionPanel().getQuestionPrompt().setText(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", questionController.getQuestions().get(0).getQuestionPrompt()));
			for (String categories : questionController.getQuestions().get(0).getRelatedCategories())
				priorityController.changePriority(categories, questionController.getPreviousPriorities().peek());
			questionController.getPreviousPriorities().pop();
			if (questionController.getUsedQuestions().size() == 0)
				surveyFrame.getQuestionPanel().remove(surveyFrame.getQuestionPanel().getBackButton());
			surveyFrame.getQuestionPanel().revalidate();
			surveyFrame.getQuestionPanel().repaint();
			
		}
		
	}

	
	

}
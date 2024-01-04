/*
Name: Daniel Zheng
Date: Dec 5
Description: This class displays the question and the buttons that the user can press on

*/

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.SurveyController;

public class QuestionPanel extends JPanel implements MouseListener {
	
	//Creates the sizes of the QuestionPanel we won't have to change all sizes
	public static final int QUESTION_SIZE_X = 1440;
	public static final int QUESTION_SIZE_Y = 900 - 115;
	
	//Creates all the attributes
	private JLabel questionPrompt;
	private RoundButton button1, button2, button3, button4, button5, button6;
	private JGradientButton skipButton, backButton;
	
	//Constructor method
	public QuestionPanel() {
		
		//Configures the JPanel
		setLayout(null);
		setOpaque(false);
		setVisible(true);
		
		//Adds and formats all the attributes 
		questionPrompt = new JLabel(String.format("<html><p body style='text-align:center'>%s</p></html>\\\"", SurveyController.questionController.getQuestions().get(0).getQuestionPrompt()));
		questionPrompt.setBounds(0, 40, 1440, 200);
		questionPrompt.setFont(new Font("Arial", Font.BOLD, 50));
		questionPrompt.setForeground(Color.decode("#1A3351"));
		questionPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		questionPrompt.setVerticalAlignment(SwingConstants.CENTER);
		add(questionPrompt);
		
		skipButton = new JGradientButton("Skip");
		skipButton.setBounds(1440 - 320 - 30, 600, 300, 110);
		skipButton.setOpaque(true);
		skipButton.setFont(new Font("Arial", Font.BOLD, 30));
		skipButton.setHorizontalAlignment(SwingConstants.CENTER);
		skipButton.setVerticalAlignment(SwingConstants.CENTER);
		skipButton.setFocusPainted(false);
		add(skipButton);
		
		backButton = new JGradientButton("Back");
		backButton.setBounds(1440 - 320 - 320 - 30, 600, 300, 110);
		backButton.setOpaque(true);
		backButton.setFont(new Font("Arial", Font.BOLD, 30));
		backButton.setForeground(Color.BLACK);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setVerticalAlignment(SwingConstants.CENTER);
		backButton.setFocusPainted(false);
		backButton.setEnabled(false);
		
		button1 = new RoundButton("1");
		button1.setBounds((1440-150*6)/7, 300, 150, 150);
	    button1.setForeground(Color.BLUE);
	    button1.setFont(new Font("Arial", Font.BOLD, 25));
	    button1.addMouseListener(this);
	    add(button1);
	    
	    button2 = new RoundButton("2");
		button2.setBounds(2*(1440-150*6)/7 + 150, 300, 150, 150);
	    button2.setForeground(Color.BLUE);
	    button2.setFont(new Font("Arial", Font.BOLD, 25));
	    button2.addMouseListener(this);
	    add(button2);
	    
	    button3 = new RoundButton("3");
		button3.setBounds(3*(1440-150*6)/7 + 300, 300, 150, 150);
	    button3.setForeground(Color.BLUE);
	    button3.setFont(new Font("Arial", Font.BOLD, 25));
	    button3.addMouseListener(this);
	    add(button3);
	    
	    button4 = new RoundButton("4");
		button4.setBounds(4*(1440-150*6)/7 + 450, 300, 150, 150);
	    button4.setForeground(Color.BLUE);
	    button4.setFont(new Font("Arial", Font.BOLD, 25));
	    button4.addMouseListener(this);
	    add(button4);
	    
	    button5 = new RoundButton("5");
		button5.setBounds(5*(1440-150*6)/7 + 600, 300, 150, 150);
	    button5.setForeground(Color.BLUE);
	    button5.setFont(new Font("Arial", Font.BOLD, 25));
	    button5.addMouseListener(this);
	    add(button5);
	    
	    button6 = new RoundButton("6");
		button6.setBounds(6*(1440-150*6)/7 + 750, 300, 150, 150);
	    button6.setForeground(Color.BLUE);
	    button6.setFont(new Font("Arial", Font.BOLD, 25));
	    button6.addMouseListener(this);
	    add(button6);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//When the user hovers a button, it will appear larger, indicating that the user is hovering it
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (e.getSource() == button1) {
			
			button1.setBounds((1440-150*6)/7 - ((1440-150*6)/7)/4, 300 - ((1440-150*6)/7)/4, 150 + ((1440-150*6)/7)/2, 150 + ((1440-150*6)/7)/2);
			button1.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button2) {
			
			button2.setBounds(2*(1440-150*6)/7 + 150 - ((1440-150*6)/7)/4, 300 - ((1440-150*6)/7)/4, 150 + ((1440-150*6)/7)/2, 150 + ((1440-150*6)/7)/2);
			button2.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button3) {
			
			button3.setBounds(3*(1440-150*6)/7 + 300 - ((1440-150*6)/7)/4, 300 - ((1440-150*6)/7)/4, 150 + ((1440-150*6)/7)/2, 150 + ((1440-150*6)/7)/2);
			button3.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button4) {
			
			button4.setBounds(4*(1440-150*6)/7 + 450 - ((1440-150*6)/7)/4, 300 - ((1440-150*6)/7)/4, 150 + ((1440-150*6)/7)/2, 150 + ((1440-150*6)/7)/2);
			button4.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button5) {
			
			button5.setBounds(5*(1440-150*6)/7 + 600 - ((1440-150*6)/7)/4, 300 - ((1440-150*6)/7)/4, 150 + ((1440-150*6)/7)/2, 150 + ((1440-150*6)/7)/2);
			button5.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button6) {
			
			button6.setBounds(6*(1440-150*6)/7 + 750 - ((1440-150*6)/7)/4, 300 - ((1440-150*6)/7)/4, 150 + ((1440-150*6)/7)/2, 150 + ((1440-150*6)/7)/2);
			button6.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();
			
		}
		
	}

	//When the user unhovers the button, it will go back to its original size
	@Override
	public void mouseExited(MouseEvent e) {
		
		if (e.getSource() == button1) {
			
			button1.setBounds((1440-150*6)/7, 300, 150, 150);
			button1.setFont(new Font("Arial", Font.BOLD, 25));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button2) {
			
			button2.setBounds(2*(1440-150*6)/7 + 150, 300, 150, 150);
			button2.setFont(new Font("Arial", Font.BOLD, 25));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button3) {
			
			button3.setBounds(3*(1440-150*6)/7 + 300, 300, 150, 150);
			button3.setFont(new Font("Arial", Font.BOLD, 25));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button4) {
			
			button4.setBounds(4*(1440-150*6)/7 + 450, 300, 150, 150);
			button4.setFont(new Font("Arial", Font.BOLD, 25));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button5) {
			
			button5.setBounds(5*(1440-150*6)/7 + 600, 300, 150, 150);
			button5.setFont(new Font("Arial", Font.BOLD, 25));
			revalidate();
			repaint();
			
		}
		
		if (e.getSource() == button6) {
			
			button6.setBounds(6*(1440-150*6)/7 + 750, 300, 150, 150);
			button6.setFont(new Font("Arial", Font.BOLD, 25));
			revalidate();
			repaint();
			
		}
		
	}

	public JLabel getQuestionPrompt() {
		return questionPrompt;
	}

	public void setQuestionPrompt(JLabel questionPrompt) {
		this.questionPrompt = questionPrompt;
	}

	public RoundButton getButton1() {
		return button1;
	}

	public void setButton1(RoundButton button1) {
		this.button1 = button1;
	}

	public RoundButton getButton2() {
		return button2;
	}

	public void setButton2(RoundButton button2) {
		this.button2 = button2;
	}

	public RoundButton getButton3() {
		return button3;
	}

	public void setButton3(RoundButton button3) {
		this.button3 = button3;
	}

	public RoundButton getButton4() {
		return button4;
	}

	public void setButton4(RoundButton button4) {
		this.button4 = button4;
	}

	public RoundButton getButton5() {
		return button5;
	}

	public void setButton5(RoundButton button5) {
		this.button5 = button5;
	}

	public RoundButton getButton6() {
		return button6;
	}

	public void setButton6(RoundButton button6) {
		this.button6 = button6;
	}

	public JGradientButton getSkipButton() {
		return skipButton;
	}

	public void setSkipButton(JGradientButton skipButton) {
		this.skipButton = skipButton;
	}

	public JGradientButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JGradientButton backButton) {
		this.backButton = backButton;
	}

	public static int getQuestionSizeX() {
		return QUESTION_SIZE_X;
	}

	public static int getQuestionSizeY() {
		return QUESTION_SIZE_Y;
	}

}

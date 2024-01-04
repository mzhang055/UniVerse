/*
Name: Daniel Zheng
Date: Dec 9
Description: This panel will display the top categories that the user fits

*/

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.LoginController;
import controller.SurveyController;

public class SurveyResultPanel extends JPanel implements MouseListener {

	// Creates attributes
	private RoundButton choice1, choice2, choice3;
	private static JLabel choiceLabel1, choiceLabel2, choiceLabel3;
	private JGradientButton findMore;

	// Constructor method
	public SurveyResultPanel() {

		// Configures the panel
		setLayout(null);
		setOpaque(false);
		setVisible(true);

		// Sorts the priorities after the previous frame
		SurveyController.priorityController.getList().sortPriority();

		// Add the attributes onto the JPanel
		findMore = new JGradientButton("Find More Programs");
		findMore.setBounds(1440 - 320 - 30, 600, 300, 110);
		findMore.setFont(new Font("Arial", Font.BOLD, 25));
		findMore.setHorizontalAlignment(SwingConstants.CENTER);
		findMore.setVerticalAlignment(SwingConstants.CENTER);
		findMore.setFocusPainted(false);
		add(findMore);

		choice1 = new RoundButton("Choice 1");
		choice1.setBounds(325, (785 - 600) / 4 - 25, 175, 175);
		choice1.setForeground(Color.BLUE);
		choice1.setFont(new Font("Arial", Font.BOLD, 35));
		choice1.addMouseListener(this);
		add(choice1);

		choice2 = new RoundButton("Choice 2");
		choice2.setBounds(325, 2 * (785 - 600) / 4 + 200 - 25, 175, 175);
		choice2.setForeground(Color.BLUE);
		choice2.setFont(new Font("Arial", Font.BOLD, 35));
		choice2.addMouseListener(this);
		add(choice2);

		choice3 = new RoundButton("Choice 3");
		choice3.setBounds(325, 3 * (785 - 600) / 4 + 400 - 25, 175, 175);
		choice3.setForeground(Color.BLUE);
		choice3.setFont(new Font("Arial", Font.BOLD, 35));
		choice3.addMouseListener(this);
		add(choice3);

		choiceLabel1 = new JLabel(SurveyController.priorityController.getList().get(0).getCategoryName());
		choiceLabel1.setBounds(550, (785 - 600) / 4 + 25, 800, 100);
		choiceLabel1.setForeground(Color.decode("#1A3351"));
		choiceLabel1.setFont(new Font("Arial", Font.BOLD, 50));
		add(choiceLabel1);

		choiceLabel2 = new JLabel(SurveyController.priorityController.getList().get(1).getCategoryName());
		choiceLabel2.setBounds(550, 2 * (785 - 600) / 4 + 200 + 25, 800, 100);
		choiceLabel2.setForeground(Color.decode("#1A3351"));
		choiceLabel2.setFont(new Font("Arial", Font.BOLD, 50));
		add(choiceLabel2);

		choiceLabel3 = new JLabel(SurveyController.priorityController.getList().get(2).getCategoryName());
		choiceLabel3.setBounds(550, 3 * (785 - 600) / 4 + 400 + 25, 800, 100);
		choiceLabel3.setForeground(Color.decode("#1A3351"));
		choiceLabel3.setFont(new Font("Arial", Font.BOLD, 50));
		add(choiceLabel3);

	}

	// --michelle
	// this method sends the user's survey results to the sql database so the user's
	// results history can be viewed after they logout
	public static void updateSurveyChoices(String username) {

		// initialize their survey choices and update on database
		String choice1 = getChoiceLabel1().getText();
		String choice2 = getChoiceLabel2().getText();
		String choice3 = getChoiceLabel3().getText();
		LoginController.updateSurveyChoices(username, choice1, choice2, choice3);

	}
	// --end

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == choice1) {

			choice1.setBounds(325 - 13, 25 - 13, 200, 200);
			choice1.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();

		}

		if (e.getSource() == choice2) {

			choice2.setBounds(325 - 13, 2 * (785 - 600) / 4 + 200 - 25 - 13, 200, 200);
			choice2.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();

		}

		if (e.getSource() == choice3) {

			choice3.setBounds(325 - 13, 3 * (785 - 600) / 4 + 400 - 25 - 13, 200, 200);
			choice3.setFont(new Font("Arial", Font.BOLD, 40));
			revalidate();
			repaint();

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == choice1) {

			choice1.setBounds(325, 50 - 25, 175, 175);
			choice1.setFont(new Font("Arial", Font.BOLD, 35));
			revalidate();
			repaint();

		}

		if (e.getSource() == choice2) {

			choice2.setBounds(325, 2 * (785 - 600) / 4 + 200 - 25, 175, 175);
			choice2.setFont(new Font("Arial", Font.BOLD, 35));
			revalidate();
			repaint();

		}

		if (e.getSource() == choice3) {

			choice3.setBounds(325, 3 * (785 - 600) / 4 + 400 - 25, 175, 175);
			choice3.setFont(new Font("Arial", Font.BOLD, 35));
			revalidate();
			repaint();

		}

	}

	// Getters and setters
	public RoundButton getChoice1() {
		return choice1;
	}

	public void setChoice1(RoundButton choice1) {
		this.choice1 = choice1;
	}

	public RoundButton getChoice2() {
		return choice2;
	}

	public void setChoice2(RoundButton choice2) {
		this.choice2 = choice2;
	}

	public RoundButton getChoice3() {
		return choice3;
	}

	public void setChoice3(RoundButton choice3) {
		this.choice3 = choice3;
	}

	public static JLabel getChoiceLabel1() {
		return choiceLabel1;
	}

	public static void setChoiceLabel1(JLabel choiceLabel1) {
		SurveyResultPanel.choiceLabel1 = choiceLabel1;
	}

	public static JLabel getChoiceLabel2() {
		return choiceLabel2;
	}

	public static void setChoiceLabel2(JLabel choiceLabel2) {
		SurveyResultPanel.choiceLabel2 = choiceLabel2;
	}

	public static JLabel getChoiceLabel3() {
		return choiceLabel3;
	}

	public static void setChoiceLabel3(JLabel choiceLabel3) {
		SurveyResultPanel.choiceLabel3 = choiceLabel3;
	}

	public JGradientButton getFindMore() {
		return findMore;
	}

	public void setFindMore(JGradientButton findMore) {
		this.findMore = findMore;
	}

}
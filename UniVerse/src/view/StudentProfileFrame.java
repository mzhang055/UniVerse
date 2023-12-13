package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.StudentData;

public class StudentProfileFrame extends JFrame implements ActionListener{
	
	public StudentProfileFrame() {
		super("Home Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 900);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		
		UserSetUpFrame user = new UserSetUpFrame();
		
		// debug
		System.out.println("Course Data List:");
		for (StudentData data : user.courseDataList) {
			System.out.println("Course Code: " + data.getCourseCode() + ", Grade: " + data.getGrade());
		}
		System.out.println();

	}
	
	

}

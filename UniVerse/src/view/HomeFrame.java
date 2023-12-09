package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class HomeFrame extends JFrame implements ActionListener{
	
	
	
	public HomeFrame() {
//		super("Home Frame");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(1440, 900);
//		getContentPane().setBackground(Color.decode("F4F7FA")); 


	
		//
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
	}
	
	public static void main(String[] args) {
		new HomeFrame();
	}

}

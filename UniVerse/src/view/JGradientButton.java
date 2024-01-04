/*
Name: Daniel Zheng
Date: Dec 7


*/

package view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import controller.QuestionController;

public class JGradientButton extends JButton {
	
	private boolean mouseOver = false;
	private boolean mousePressed = false;
	private QuestionController questionController;
	
    public JGradientButton(String text) {
    	
        super(text);
		
        questionController = new QuestionController();
		MouseAdapter mouseListener = new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent me){
				if(contains(me.getX(), me.getY())){
					mousePressed = true;
					repaint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent me){
				mousePressed = false;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent me){
				mouseOver = false;
				mousePressed = false;
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent me){
				mouseOver = contains(me.getX(), me.getY());
				repaint();
			}
		};
		
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
        
    }
    
    @Override
	protected void paintComponent(Graphics grphcs) {
		
    	if(mousePressed){
			grphcs.setColor(Color.LIGHT_GRAY);
		}
    	
		else {
			
			Graphics2D g2d = (Graphics2D) grphcs;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
	        GradientPaint gp = new GradientPaint(300, 0,
	                new Color(68, 143, 228), 0, getHeight(),
	                Color.WHITE);
	        g2d.setPaint(gp);
	        g2d.fillRect(0, 0, getWidth(), getHeight());
	        
			
		}
        if (mouseOver) {
			grphcs.setColor(Color.BLUE);
		}
        
		else {
			grphcs.setColor(Color.BLACK);
		}

        grphcs.setFont(getFont());
		FontMetrics metrics = grphcs.getFontMetrics(getFont());
		int stringWidth = metrics.stringWidth(getText());
		int stringHeight = metrics.getHeight();
		grphcs.drawString(getText(), getWidth()/2 - stringWidth/2, getHeight()/2 + stringHeight/4);
        
    }

}
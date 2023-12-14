package view;

import java.awt.Color;

import javax.swing.JFrame;

public class MapViewerFrame extends JFrame {
	
	private NavigationBarPanel navBarPanel = new NavigationBarPanel(); 
	private MapViewerPanel mapPanel = new MapViewerPanel(); 
	

	public MapViewerFrame() {
		
		navBarPanel.setBounds(0, 0, 1440, 90);
		add(navBarPanel); 
		
		mapPanel.setBounds(0, 90, 1440, 810);
		add(mapPanel); 
		
		// set JFrame
		setLayout(null);
		setSize(1440, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(188, 202, 218));
		setVisible(true); 
		
	}
	
	public NavigationBarPanel getNavBarPanel() {
		return navBarPanel;
	}

	public void setNavBarPanel(NavigationBarPanel navBarPanel) {
		this.navBarPanel = navBarPanel;
	}

	public MapViewerPanel getMapPanel() {
		return mapPanel;
	}

	public void setMapPanel(MapViewerPanel mapPanel) {
		this.mapPanel = mapPanel;
	}

}
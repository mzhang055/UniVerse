package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

import model.CalculateDistance;
import model.SelectionAdapter;
import model.SelectionPainter;
import model.StudentData;
import model.SwingWaypoint;
import model.SwingWaypointOverlayPainter;
import model.University;
import model.UniversityFileInput;
import view.MapViewerFrame;
import view.UserSetUpFrame;

public class MapController implements ActionListener {

	// this array stores all the universities + their specific info
	public static University[] universityArray = new University[22];

	// this array is used to determine which universities are within the distance
	// range the user selects
	public static boolean[] rangeDistance = new boolean[23];

	// this array stores the distance between user's current location and each
	// university
	public static double[] uniDistance = new double[22];

	// this array stores all university locations + user's current location
	public static GeoPosition[] locationsArray = new GeoPosition[23];

	// this ArrayList stores the user's bookmarked universities
	public static ArrayList<Integer> bookmarked = new ArrayList<Integer>();

	public static GeoPosition currentLocation;

	public MapViewerFrame mapFrame;

	public MapController(String longitude, String latitude) {

		currentLocation = new GeoPosition(Double.parseDouble(longitude),
				Double.parseDouble(latitude));
		
		// fills University array
		new UniversityFileInput();

		mapFrame = new MapViewerFrame();

		// initialize each element in array to false
		for (int index = 0; index < rangeDistance.length; index++) {

			rangeDistance[index] = false;
		}

		// ActionListeners
		mapFrame.getMapPanel().getHelp().addActionListener(this);
		mapFrame.getMapPanel().getBookmark().addActionListener(this);
		mapFrame.getMapPanel().getDistanceRadius().addActionListener(this);
		

		
		
		System.out.println(longitude);
		System.out.println(latitude);
		
	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {

		// if help button is clicked
		if (e.getSource() == mapFrame.getMapPanel().getHelp()) {

			// call method to display first set of instructions
			displayInstructions();

		}

		// if the choicebox is pressed
		else if (e.getSource() == mapFrame.getMapPanel().getDistanceRadius()) {

			// determine which option is picked, and based on that, pass the appropriate
			// minimum and maximum values to the Class
			if (mapFrame.getMapPanel().getDistanceRadius()
					.getSelectedItem() == mapFrame.getMapPanel().getDistanceChoice()[0])
				new CalculateDistance(locationsArray[22], 1, 30);

			else if (mapFrame.getMapPanel().getDistanceRadius()
					.getSelectedItem() == mapFrame.getMapPanel().getDistanceChoice()[1])
				new CalculateDistance(locationsArray[22], 1, 60);

			else if (mapFrame.getMapPanel().getDistanceRadius()
					.getSelectedItem() == mapFrame.getMapPanel().getDistanceChoice()[2])
				new CalculateDistance(locationsArray[22], 1, 90);

			else
				new CalculateDistance(locationsArray[22], 1, 0);

			// call this method to readd all locations onto the map
			mapFrame.getMapPanel().addLocation(true);

		}

		// if bookmark button is picked
		else if (e.getSource() == mapFrame.getMapPanel().getBookmark()) {

			// create JPanel
			JPanel bookmarkedPane = new JPanel();

			// add all images to the JPanel
			for (int i = 0; i < bookmarked.size(); i++) {
				JLabel image = new JLabel(universityArray[bookmarked.get(i)].getLogo());
				image.setSize(60, 60);
				bookmarkedPane.add(image);
			}

			// display in a JOptionPane
			JOptionPane.showMessageDialog(mapFrame, bookmarkedPane, "Bookmarked Universities", 1);

		}

	}

	// This method displays the first set of instructions
	private void displayInstructions() {

		Object[] options = { "Next" }; // only next button option
		int button = JOptionPane.showOptionDialog(mapFrame,
				"Welcome to the University Interactive Map! Click Next to look at further instructions!",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, // do not use
																											// a custom
																											// Icon
				options, // the titles of buttons
				options[0]); // default button title

		// if next button is clicked, open second instructions page
		if (button == 0) {

			displayInstructions2();
		}

	}

	// This method displays the second set of instructions
	private void displayInstructions2() {

		Object[] options = { "Next", "Back" }; // the titles of buttons
		int button = JOptionPane.showOptionDialog(mapFrame,
				"To zoom in and out on the map, use your mousepad. As you can see, most University locations in Ontario are here "
						+ "and their icons.",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]); // default button title

		// if next button is clicked, open third instructions page
		if (button == 0) {

			displayInstructions3();

		}

		// if back button is clicked, open first instructions page
		else if (button == 1) {

			displayInstructions();
		}

	}

	// This method displays the third set of instructions
	private void displayInstructions3() {

		Object[] options = { "Next", "Back" }; // the titles of buttons
		int button = JOptionPane.showOptionDialog(mapFrame,
				"To learn more about a specific university, click on the icon where you can view the general and other important info!",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]); // default button title

		// if next button is clicked, open third instructions page
		if (button == 0) {

			displayInstructions4();

		}

		// if back button is clicked, open first instructions page
		else if (button == 1) {

			displayInstructions2();
		}

	}

	// This method displays the fourth set of instructions
	private void displayInstructions4() {
		Object[] options = { "Next", "Back" }; // the titles of buttons
		int button = JOptionPane.showOptionDialog(mapFrame,
				"Your current location is the same as the one in your student profile, and can be identified by the red location pin. "
						+ "All of the distances between universities are based on your current location",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]); // default button title

		// if next button is clicked, open third instructions page
		if (button == 0) {

			displayInstructions5();

		}

		// if back button is clicked, open first instructions page
		else if (button == 1) {

			displayInstructions3();
		}

	}

	// This method displays the fifth set of instructions
	private void displayInstructions5() {

		Object[] options = { "Next", "Back" }; // the titles of buttons
		int button = JOptionPane.showOptionDialog(mapFrame,
				"To view universities within a certain radius, feel free to click on the options on the top left of the map. ",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]); // default button title

		// if next button is clicked, open third instructions page
		if (button == 0) {

			displayInstructions6();

		}

		// if back button is clicked, open first instructions page
		else if (button == 1) {

			displayInstructions4();
		}

	}

	// This method displays the sixth set of instructions
	private void displayInstructions6() {

		Object[] options = { "Next", "Back" }; // the titles of buttons
		int button = JOptionPane.showOptionDialog(mapFrame,
				"To view bookmarked universities, click on the button in the middle where you will be able to see all of the University Icons you have bookmarked.",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]); // default button title

		// if next button is clicked, open third instructions page
		if (button == 0) {

			displayInstructions7();

		}

		// if back button is clicked, open first instructions page
		else if (button == 1) {

			displayInstructions5();
		}

	}

	// This method displays the seventh set of instructions
	private void displayInstructions7() {

		Object[] options = { "Done" }; // if next button is clicked, open second instructions page
		int button = JOptionPane.showOptionDialog(mapFrame,
				"If you would like to see these instructions again, click the 'HELP' button on the top right of the screen. "
						+ "Enjoy exploring the map!",
				"Instructions Information", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]); // default button title

		// if back button is clicked, open second instructions page
		if (button == 0) {

			JOptionPane.getRootFrame().dispose();

		}

	}

}
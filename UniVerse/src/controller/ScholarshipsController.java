package controller;

import view.ScholarshipsFrame;
import view.ScholarshipsFrame2;

public class ScholarshipsController {
    public static ScholarshipsFrame scholarshipsFrame;
    public static ScholarshipsFrame2 scholarshipsFrame2;

    public ScholarshipsController() {
        scholarshipsFrame = new ScholarshipsFrame();
        scholarshipsFrame2 = null;
        initListeners();
        scholarshipsFrame.setVisible(true);
    }

    private void initListeners() {
        scholarshipsFrame.setScholarshipSelectedListener(selectedScholarship -> {
            scholarshipsFrame.setVisible(false);
            scholarshipsFrame2 = new ScholarshipsFrame2(selectedScholarship);
            scholarshipsFrame2.setVisible(true);
        });
    }

    public static void main(String[] args) {
        // Run the controller
        javax.swing.SwingUtilities.invokeLater(ScholarshipsController::new);
    }
}
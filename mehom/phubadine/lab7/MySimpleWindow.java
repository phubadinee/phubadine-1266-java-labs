package mehom.phubadine.lab7;

import java.awt.*;
import javax.swing.*;

/* 
 * The Java class MySimpleWindow extends JFrame and represents a simple window with 
 * buttons. It contains a button panel with "Reset" and "Submit" buttons. The class 
 * provides methods to set up the frame's components, features, and initializes the 
 * window through the createAndShowGUI method.
 * 
 * My Simple Window
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class MySimpleWindow extends JFrame {

    // Static panels and buttons for buttonPanel
    protected static JPanel buttonPanel, mainPanel;
    protected JButton resetButton, submitButton;

    // Constructor with window title
    public MySimpleWindow(String title) {
        super(title);
    }

    // Method to add components to the contentPane
    protected void addComponents(Container contentPane) {
        buttonPanel = new JPanel();

        // Create "Reset" and "Submit" buttons
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        // Add buttons to buttonPanel
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        // Set FlowLayout for the contentPane and add buttonPanel
        contentPane.setLayout(new FlowLayout());
        contentPane.add(buttonPanel);
    }

    // Method to set frame features
    public void setFrameFeatures() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.setFrameFeatures();
    }

    // Main method to invoke GUI creation in the Event Dispatch Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

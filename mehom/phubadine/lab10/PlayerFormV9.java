package mehom.phubadine.lab10;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* 
 * The code extends a GUI player form, adding a JSlider for years of experience. 
 * It includes a ChangeListener to display a message when the slider value is no longer adjusting, 
 * indicating the selected years of experience. The main method initializes and launches the application 
 * through SwingUtilities.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {
    protected int value;
    // Constructor
    public PlayerFormV9(String title) {
        super(title);
    }

    // Override method to add event listeners
    @Override 
    public void addListeners() {
        super.addListeners();
        yearSlider.addChangeListener(this); // Add ChangeListener to the yearSlider
    }

    // Implement ChangeListener method to handle slider changes
    public void stateChanged(ChangeEvent e) {
        JSlider src = (JSlider) e.getSource();
        boolean adjust = src.getValueIsAdjusting();

        // Check if the value is no longer adjusting
        if (!adjust) {
            // Get the selected value from the JSlider
            value = yearSlider.getValue();
            // Display a message with the selected year of experience
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + value); 
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.addListeners();
        msw.setFrameFeatures();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

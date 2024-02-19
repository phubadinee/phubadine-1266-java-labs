package mehom.phubadine.lab9;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/* 
 * The code defines a Swing-based GUI for a dice game window, 
 * where buttons for "Roll," "High," and "Low" are added along with a canvas 
 * displaying a dice image. The application generates a random initial dice roll, 
 * and the GUI is displayed upon execution.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class DiceGameWindow extends JFrame {

    // Variables to hold components
    protected DiceImageCanvas diceImageCanvas;
    protected int diceRoll;
    protected JPanel buttonsPanel;
    protected JButton rollButton, highButton, lowButton;

    // Constructor
    public DiceGameWindow(String title) {
        super(title);
        Random rand = new Random();     // Initialize a random number generator to simulate dice rolls
        diceRoll = rand.nextInt(6) + 1;     // Generate a random number between 1 and 6 to simulate a dice roll
        diceImageCanvas = new DiceImageCanvas(diceRoll);    // Create a canvas to display the dice image based on the roll
    }

    // Set up the frame features (size, close operation, visibility, etc.)
    public void setFrameFeatures() {
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Add components (buttons and dice image canvas) to the frame
    public void addComponents() {
        buttonsPanel = new JPanel(new FlowLayout());
        rollButton = new JButton("Roll");
        highButton = new JButton("High");
        lowButton = new JButton("Low");
        buttonsPanel.add(highButton);
        buttonsPanel.add(lowButton);
        buttonsPanel.add(rollButton);

        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(diceImageCanvas, BorderLayout.CENTER);
    }

    // Static method to create and show the GUI
    public static void createAndShowGUI() {
        DiceGameWindow dgw = new DiceGameWindow("DiceGameWindow Version 1");
        dgw.addComponents();
        dgw.setFrameFeatures();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

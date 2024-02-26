import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 
 * The code defines a Java Swing application that creates a JFrame with a button. 
 * When the button is clicked, it opens a color chooser dialog, and the selected color 
 * sets the background color of the panel within the frame. The application is initiated 
 * through the main method using SwingUtilities.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class ColorChooserExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Color Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        JButton colorButton = new JButton("Choose Color");

        // Add ActionListener to the button for handling color selection
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a color chooser dialog and get the selected color
                Color selectedColor = JColorChooser.showDialog(frame, "Choose a Color", Color.BLACK);

                // Set the background color of the panel to the selected color
                if (selectedColor != null) {
                    panel.setBackground(selectedColor);
                }
            }
        });

        // Add components to the panel
        panel.add(colorButton);
        // Add the panel to the main frame
        frame.add(panel);
        // Make the frame visible
        frame.setVisible(true);
    }
}

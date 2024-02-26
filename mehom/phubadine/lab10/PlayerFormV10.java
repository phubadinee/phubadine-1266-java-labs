package mehom.phubadine.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuListener;

/* 
 * The code defines a Swing GUI application (PlayerFormV10) that extends a previous version (PlayerFormV9). 
 * It adds menu items for file operations, color options, and font sizes, with corresponding action handling methods, 
 * and can be launched through the main method using SwingUtilities.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV10 extends PlayerFormV9 implements ActionListener {
    
    // Constructor
    public PlayerFormV10(String title) {
        super(title);
    }
    
    // Override method to add action listeners for menu items
    @Override
    public void addListeners() {
        super.addListeners();
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        redColor.addActionListener(this);
        greenColor.addActionListener(this);
        blueColor.addActionListener(this);
        size16.addActionListener(this);
        size20.addActionListener(this);
        size24.addActionListener(this);
    }

    // Override method to handle action events
    @Override 
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JMenuItem src = (JMenuItem) e.getSource();

        // Check which menu item or color option is selected and call corresponding handling methods
        if (src == newItem || src == openItem || src == saveItem) {
            handleFileMenu(src);
        } else if (src == redColor) {
            handleColorMenu(Color.RED);
        } else if (src == greenColor) {
            handleColorMenu(Color.GREEN);
        } else if (src == blueColor) {
            handleColorMenu(Color.BLUE);
        } else if (src == size16 || src == size20 || src == size24) {
            handleSizeMenu(src);
        }
    }

    // Method to handle file menu items
    public void handleFileMenu(JMenuItem fileItem) {
        String valueFileItem = fileItem.getActionCommand();
        JOptionPane.showMessageDialog(this, "You click menu " + valueFileItem); 
    }

    // Method to handle font size menu items
    public void handleSizeMenu(JMenuItem sizeItem) {
        int valueSize = Integer.parseInt(sizeItem.getText());
        txtArea.setFont(new Font("Serif", Font.BOLD, valueSize));
    }

    // Method to handle color menu items
    public void handleColorMenu(Color color) {
        nameTextField.setForeground(color);
        nationalityTextField.setForeground(color);
        dataOfBirthTextField.setForeground(color);
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
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

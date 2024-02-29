package mehom.phubadine.lab9;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/* 
 * PlayerFormV7 extends a previous version, adding radio button and checkbox item 
 * listeners to handle state changes. It displays messages for gender updates and 
 * checkbox interactions, with GUI components created using Swing.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {

    // Constructor for PlayerFormV7, calling the constructor of the superclass PlayerFormV6
    public PlayerFormV7(String title) {
        super(title);
    }

    // Method to add item listeners for radio buttons and checkboxes
    @Override
    public void addListeners() {
        super.addListeners();
        maleRadioButton.addItemListener(this);
        femaleRadioButton.addItemListener(this);
        readingCheckBox.addItemListener(this);
        browsingCheckBox.addItemListener(this);
        travelingCheckBox.addItemListener(this);
        sleepingCheckBox.addItemListener(this);
    }

    // ItemStateChanged method to handle changes in the state of radio buttons and checkboxes
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource();

        
        // Check sorce state changed
        if (src == maleRadioButton && e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Male");
        } else if (src == femaleRadioButton && e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Female");
        } else if (src == readingCheckBox || src == browsingCheckBox ||
                src == travelingCheckBox || src == sleepingCheckBox) {
            handleCheckBox((JCheckBox) src);
        }
    }

    // Method to handle checkbox changes with messages
    public void handleCheckBox(JCheckBox checkbox) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (checkbox.isSelected()) {
                    JOptionPane.showMessageDialog(PlayerFormV7.this,  checkbox.getName() + " is one of the hobbies");
                } else {
                    JOptionPane.showMessageDialog(PlayerFormV7.this,  checkbox.getName() + " is no longer one of the hobbies");
                }
            }
        });
    }

    // Override method to set names for checkboxes
    @Override
    protected void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        readingCheckBox.setName("Reading");
        browsingCheckBox.setName("Browsing");
        sleepingCheckBox.setName("Sleeping");
        travelingCheckBox.setName("Traveling");
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
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

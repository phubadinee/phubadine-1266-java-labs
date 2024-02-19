package mehom.phubadine.lab9;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {

    public PlayerFormV7(String title) {
        super(title);
    }

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

    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource();

        if (src == maleRadioButton && e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Male");
        } else if (src == femaleRadioButton && e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Female");
        } else if (src == readingCheckBox || src == browsingCheckBox ||
                src == travelingCheckBox || src == sleepingCheckBox) {
            handleCheckBox((JCheckBox) src);
        }
    }

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

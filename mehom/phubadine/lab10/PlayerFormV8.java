package mehom.phubadine.lab10;

import java.util.List;
import javax.swing.JList;
import javax.swing.JList.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


import mehom.phubadine.lab9.PlayerFormV7;

/* 
 * The Java code extends a Swing GUI application, adding a JList for sports selection. 
 * It implements ListSelectionListener to handle changes in the selected sports list, displaying a message 
 * with the selected sports. The code is organized, utilizing inheritance from a previous version, and includes 
 * comments for clarity.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    ListSelectionModel listSelectionModel;

    // Constructor
    public PlayerFormV8(String title) {
        super(title);
    }

    // Override method to add event listeners
    @Override
    public void addListeners() {
        super.addListeners();
        listSelectionModel = sportList.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
    }

    // Override method to handle list selection changes
    @Override
    public void valueChanged(ListSelectionEvent e) {
        boolean adjust = e.getValueIsAdjusting();
        if (!adjust) {
            // Get selected values from the JList
            List<String> selectionSportValues = sportList.getSelectedValuesList();
            
            // Create a string with the selected sports
            String valueOfSports = "";
            for (String value : selectionSportValues) {
              valueOfSports += value.toString() + " ";
            }

            // Display a message with the selected sports
            JOptionPane.showMessageDialog(this, "Selected sports are " + valueOfSports); 
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");
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

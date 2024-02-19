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

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    ListSelectionModel listSelectionModel;
    public PlayerFormV8(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        listSelectionModel = sportList.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        boolean adjust = e.getValueIsAdjusting();
        if (!adjust) {
            List<String> selectionSportValues = sportList.getSelectedValuesList();
            String valueOfSports = "";
            for (String value : selectionSportValues) {
              valueOfSports += value.toString() + " ";
            }
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

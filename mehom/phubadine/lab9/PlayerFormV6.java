package mehom.phubadine.lab9;

import mehom.phubadine.lab8.PlayerFormV5;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.ItemSelectable;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener, ItemListener {
    protected String genderResult;
    protected ItemSelectable itemSelectable;
    protected ArrayList<String> hobbiesArrayList= new ArrayList<String>();

    public PlayerFormV6(String title) {
        super(title);
    }

    public void addListeners() {
        submitButton.addActionListener(this);
        readingCheckBox.addItemListener(this);
        browsingCheckBox.addItemListener(this);
        sleepingCheckBox.addItemListener(this);
        travelingCheckBox.addItemListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == submitButton) {
            String name = nameTextField.getText();
            String national = nationalityTextField.getText();
            String birth = dataOfBirthTextField.getText();

            if (maleRadioButton.isSelected()) {
                genderResult = maleRadioButton.getText();
            } else {
                genderResult = femaleRadioButton.getText();
            }
            String playerType = (String) typesCombo.getSelectedItem();
            String sportType = (String) sportList.getSelectedValue();
            JOptionPane.showMessageDialog(this, name +" has nationality as "+ national + " and was born on "+ birth + 
            ", has gender as " + genderResult + " is a "+ playerType + " player, has hobbies as " + displayHobbies(hobbiesArrayList) +
            sportType);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        JCheckBox srcItem = (JCheckBox) e.getItemSelectable();
        String hobbiesSelected = srcItem.getActionCommand();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            hobbiesArrayList.add(hobbiesSelected);
            // System.out.println("selected " + hobbiesSelected);
        } else {
            hobbiesArrayList.remove(hobbiesSelected);
            // System.out.println("deSelected " + hobbiesSelected);
        }
    }

    public String displayHobbies(ArrayList<String> hobbieslist) {
        String hobbiesResult = "";
        for (String val : hobbieslist) {
            hobbiesResult += val + " ";
        }
        return hobbiesResult;
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");    
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

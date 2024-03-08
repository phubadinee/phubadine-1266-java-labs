package mehom.phubadine.lab9;

import mehom.phubadine.lab8.PlayerFormV5;
import java.awt.event.*;
import java.security.PublicKey;
import java.util.List;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/* 
 * The PlayerFormV6 class extends a previous version and implements a player 
 * information form with buttons, text fields, radio buttons, checkboxes, 
 * and event listeners. It captures user input, handles button clicks, and displays 
 * player details, including hobbies and selected sports. The GUI is created using 
 * Swing components.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener, KeyListener {
    
    // Variables for storing gender result, itemSelectable, hobbiesArrayList, and an array of selected checkboxes
    protected String genderResult, name, nationality, birth, playerType, hobbies;
    protected ItemSelectable itemSelectable;
    protected ArrayList<String> hobbiesArrayList= new ArrayList<String>();
    protected ArrayList<JCheckBox> hobbieJCheckBoxs = new ArrayList<JCheckBox>();
    protected JCheckBox[] checkSelected;
    protected List sports;
    protected int[] sportIndex;
    // Constructor for PlayerFormV6, calling the constructor of the superclass PlayerFormV5
    public PlayerFormV6(String title) {
        super(title);
    }

    // Method to add action listeners for buttons and key listeners for text fields
    public void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameTextField.addKeyListener(this);
        nationalityTextField.addKeyListener(this);
        dataOfBirthTextField.addKeyListener(this);
    }

    // ActionPerformed method to handle button clicks
    @Override 
    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == submitButton) {
            JOptionPane.showMessageDialog(this, getValue());
        } else if (srcObject == resetButton) {
            nameTextField.setText("");
            nationalityTextField.setText("");
            dataOfBirthTextField.setText("");
        }
    }

    public String getValue() {
        name = nameTextField.getText();
        nationality = nationalityTextField.getText();
        birth = dataOfBirthTextField.getText();

        if (maleRadioButton.isSelected()) {
            genderResult = maleRadioButton.getText();
        } else {
            genderResult = femaleRadioButton.getText();
        }

        playerType = (String) typesCombo.getSelectedItem();
        hobbies = checkBoxSelected();
        sports = (List) sportList.getSelectedValuesList();
        sportIndex = sportList.getSelectedIndices();
        // sportSelectedObj = sportList.get
        return name +" has nationality as " + nationality + " and was born on " + birth + ", has gender as " + 
            genderResult + ", is a " + playerType + " player, has hobbies as " + hobbies + " and plays " + sports;
    }

    // KeyPressed method to handle Enter key events on text fields
    public void keyPressed(KeyEvent e) {
        JTextField source = (JTextField) e.getSource();
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {      // When ENTER pressed
            if (source.getName().equals("nameTextField")) {
                JOptionPane.showMessageDialog(this, "Name is changed to " + nameTextField.getText());
            } else if (source.getName().equals("nationalityTextField")) {
                JOptionPane.showMessageDialog(this, "Nationality is changed to " + nationalityTextField.getText());
            } else if (source.getName().equals("dataOfBirthTextField")) {
                JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + dataOfBirthTextField.getText());
            }
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // Method to concatenate selected checkboxes into a string
    public String checkBoxSelected() {
        String hobbiesResult = "";
        checkSelected = new JCheckBox[]{readingCheckBox, browsingCheckBox, sleepingCheckBox, travelingCheckBox};

        for (JCheckBox checkBox : checkSelected) {
            if (checkBox.isSelected()) {
                hobbiesResult += checkBox.getActionCommand() + " ";
                hobbieJCheckBoxs.add(checkBox);
            }
        }
        return hobbiesResult;
    }

    // Override method to add components and set names for text fields
    @Override
    protected void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        nameTextField.setName("nameTextField");
        nationalityTextField.setName("nationalityTextField");
        dataOfBirthTextField.setName("dataOfBirthTextField");
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

package mehom.phubadine.lab11;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import mehom.phubadine.lab10.PlayerFormV11;

/* 
 * The Java code defines a class PlayerFormV12 that extends another class and implements key event handling 
 * for text fields, validating and displaying messages based on user input. The main method launches 
 * a Swing GUI application for a player form with version 12.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV12 extends PlayerFormV11 {
    
    // Constructor for PlayerFormV12
    public PlayerFormV12(String title) {
        super(title);
    }

    // Override keyPressed method to handle key events
    @Override 
    public void keyPressed(KeyEvent e) {
        JTextField source = (JTextField) e.getSource();
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {      // When ENTER pressed
            if (source.getName().equals("nameTextField")) {
                checkEmptyTextField(nameTextField, nationalityTextField, "Name");
            } else if (source.getName().equals("nationalityTextField")) {
                checkEmptyTextField(nationalityTextField, dataOfBirthTextField, "Nationality");
            } else if (source.getName().equals("dataOfBirthTextField")) {
                checkEmptyTextField(dataOfBirthTextField, null, "Date of Birth");
            }
        }
    }

    // Method to check if a text field is empty and show appropriate message
    public void checkEmptyTextField(JTextField textField, JTextField nextTextField, String nameTextField) {
        if (textField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + nameTextField + textField.getText());
            textField.requestFocusInWindow();
            if (nextTextField != null) {nextTextField.setEnabled(false);}
        } else {
            if (textField == dataOfBirthTextField) {
                try {
                    String dateString = textField.getText();
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate parsedDate = LocalDate.parse(dateString, dateFormatter);
                    JOptionPane.showMessageDialog(this, nameTextField + " is changed to " + textField.getText());
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid date in " + nameTextField);
                    textField.requestFocusInWindow();
                }
            } else {
                JOptionPane.showMessageDialog(this, nameTextField + " is changed to " + textField.getText());
                if (nextTextField != null) {nextTextField.requestFocusInWindow();nextTextField.setEnabled(true);}
            }   
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.enableKeyboard();
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

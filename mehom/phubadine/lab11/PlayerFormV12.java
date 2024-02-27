package mehom.phubadine.lab11;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import mehom.phubadine.lab10.PlayerFormV11;

public class PlayerFormV12 extends PlayerFormV11 {

    public PlayerFormV12(String title) {
        super(title);
    }

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

    public void checkEmptyTextField(JTextField textField, JTextField nextTextField, String nameTextField) {
        if (textField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + nameTextField + textField.getText());
            textField.requestFocusInWindow();
            nationalityTextField.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, nameTextField + " is changed to " + textField.getText());
            if (nextTextField != null) {
                nextTextField.setEnabled(true);
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

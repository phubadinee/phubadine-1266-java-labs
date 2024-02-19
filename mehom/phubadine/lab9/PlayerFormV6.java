package mehom.phubadine.lab9;

import mehom.phubadine.lab8.PlayerFormV5;
import java.awt.event.*;
import java.security.PublicKey;
import java.util.List;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener, KeyListener {
    protected String genderResult;
    protected ItemSelectable itemSelectable;
    protected ArrayList<String> hobbiesArrayList= new ArrayList<String>();
    protected JCheckBox[] checkSelected;

    public PlayerFormV6(String title) {
        super(title);
    }

    public void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameTextField.addKeyListener(this);
        nationalityTextField.addKeyListener(this);
        dataOfBirthTextField.addKeyListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == submitButton) {
            String name = nameTextField.getText();
            String nationality = nationalityTextField.getText();
            String birth = dataOfBirthTextField.getText();

            if (maleRadioButton.isSelected()) {
                genderResult = maleRadioButton.getText();
            } else {
                genderResult = femaleRadioButton.getText();
            }

            String playerType = (String) typesCombo.getSelectedItem();
            String hobbies = checkBoxSelected();
            List sports = (List) sportList.getSelectedValuesList();

            JOptionPane.showMessageDialog(this, name +" has nationality as " + nationality + " and was born on " + birth + ", has gender as " + 
            genderResult + ", is a " + playerType + " player, has hobbies as " + hobbies + " and plays " + sports );
        } else if (srcObject == resetButton) {
            nameTextField.setText("");
            nationalityTextField.setText("");
            dataOfBirthTextField.setText("");
        }
    }

    public void keyPressed(KeyEvent e) {
        JTextField source = (JTextField) e.getSource();
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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

    public String checkBoxSelected() {
        String hobbiesResult = "";
        checkSelected = new JCheckBox[]{readingCheckBox, browsingCheckBox, sleepingCheckBox, travelingCheckBox};

        for (JCheckBox checkBox : checkSelected) {
            if (checkBox.isSelected()) {
                System.out.println(checkBox.getActionCommand());
                hobbiesResult += checkBox.getActionCommand();
            }
        }
        return hobbiesResult;
    }

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

package mehom.phubadine.lab7;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;

/* 
 * The Java class PlayerFormV1 extends MySimpleWindow and represents a player 
 * information form with name, nationality, date of birth, and gender fields. 
 * It includes radio buttons for gender selection and "Reset" and "Submit" 
 * buttons at the bottom. The form layout is organized using panels, and the class 
 * provides methods to configure and add components to the form.
 * 
 * Player Form V1
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */
public class PlayerFormV1 extends MySimpleWindow {

    // Panels and components for the form
    protected JPanel topPanel, genderRadioPanel, genderRadio;
    protected JLabel nameLabel, nationalityLabel, dataOfBirthLabel, genderLabel;
    protected JTextField nameTextField, nationalityTextField, dataOfBirthTextField;
    protected JRadioButton maleRadioButton, femaleRadioButton;
    
    public PlayerFormV1(String title) {
        super(title);
    }

    // Method to set margin for specified panels
    protected void setMargin(JPanel[] panel, int margin) {
        for (JPanel subPanel : panel) {
            subPanel.setBorder(new EmptyBorder(margin, margin, margin, margin));
        }
    }

    // Method to configure form labels
    protected void configFormLabel() {
        // Config Label and TextField
        nameLabel = new JLabel("Name:");
        nationalityLabel = new JLabel("Nationality");
        dataOfBirthLabel = new JLabel("Date of Birth (eg.,31-01-2005):"); 
        genderLabel = new JLabel("Gender:");
    }

    // Method to configure form text fields
    protected void configFormTextField() {
        nameTextField = new JTextField();
        nationalityTextField = new JTextField();
        dataOfBirthTextField = new JTextField();
    }

    // Method to create and configure radio buttons for gender selection
    protected JPanel radioFormButton() {
        // Radio Button Config
        ButtonGroup genderGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male", false);
        femaleRadioButton = new JRadioButton("Female", true);
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        
        genderRadio = new JPanel();
        genderRadio.add(maleRadioButton);
        genderRadio.add(femaleRadioButton);
        return genderRadio;

    }

    // Method to add components to the top panel
    protected void addTopPanelComponents() {
        configFormLabel();
        configFormTextField();
        
        // Top Panel Config
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4, 2, 5, 5));
        topPanel.add(nameLabel);
        topPanel.add(nameTextField);
        topPanel.add(nationalityLabel);
        topPanel.add(nationalityTextField);
        topPanel.add(dataOfBirthLabel);
        topPanel.add(dataOfBirthTextField);
        topPanel.add(genderLabel);
        topPanel.add(radioFormButton());
    }

    // Method to add "Reset" and "Submit" buttons
    protected void confirmButtons() {
        buttonPanel = new JPanel();
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
    }

    // Overridden method to add components to the contentPane
    @Override
    protected void addComponents(Container contentPane) { 
        
        addTopPanelComponents();
        confirmButtons();
        // Add Panel to ContentPane
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.SOUTH); 
        JPanel[] setPanel = {topPanel, buttonPanel};
        setMargin(setPanel, 7);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.setFrameFeatures();
    }

    // Main method to invoke GUI creation in the Event Dispatch Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
        
    }
}

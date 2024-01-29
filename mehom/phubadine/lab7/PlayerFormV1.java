package mehom.phubadine.lab7;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;

public class PlayerFormV1 extends MySimpleWindow {

    protected JPanel topPanel, genderRadioPanel, genderRadio;
    protected JLabel nameLabel, nationalityLabel, dataOfBirthLabel, genderLabel;
    protected JTextField nameTextField, nationalityTextField, dataOfBirthTextField;
    protected JRadioButton maleRadioButton, femaleRadioButton;
    
    public PlayerFormV1(String title) {
        super(title);
    }

    protected void setMargin(JPanel[] panel, int margin) {
        for (JPanel subPanel : panel) {
            subPanel.setBorder(new EmptyBorder(margin, margin, margin, margin));
        }
    }

    protected void configFormLabel() {
        // Config Label and TextField
        nameLabel = new JLabel("Name:");
        nationalityLabel = new JLabel("Nationality");
        dataOfBirthLabel = new JLabel("Date of Birth (eg.,31-01-2005):"); 
        genderLabel = new JLabel("Gender:");
    }

    protected void configFormTextField() {
        nameTextField = new JTextField();
        nationalityTextField = new JTextField();
        dataOfBirthTextField = new JTextField();
    }

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

    protected void addTopPanelComponents() {
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

    protected void confirmButtons() {
        buttonPanel = new JPanel();
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
    }

    @Override
    protected void addComponents(Container contentPane) { 
        configFormLabel();
        configFormTextField();
        addTopPanelComponents();
        confirmButtons();
        // Add Panel to ContentPane
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.SOUTH); 
        JPanel[] setPanel = {topPanel, buttonPanel};
        setMargin(setPanel, 7);
    }

    // @Override
    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
        
    }
}

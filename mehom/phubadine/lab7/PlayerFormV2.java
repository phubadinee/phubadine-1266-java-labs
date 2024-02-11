package mehom.phubadine.lab7;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

/* 
 * The Java class PlayerFormV2 extends PlayerFormV1 and enhances the player 
 * information form by adding a player type combo box and a note section with a scrollable text area. 
 * The form layout is organized using panels, and it inherits and extends 
 * functionalities from the previous version. It includes "Reset" and "Submit" buttons, 
 * allowing users to interact with the form to input additional information.
 * 
 * Player Form V2
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV2 extends PlayerFormV1 {

    // Panel for the note section
    public JPanel notePanel;

    public PlayerFormV2(String title) {
        super(title);
    }

    // Method to set margin for specified panels
    protected void setMargin(JPanel panel1, JPanel panel2, JPanel panel3, int margin) {
        panel1.setBorder(new EmptyBorder(margin, margin, margin, margin));
        panel2.setBorder(new EmptyBorder(margin, margin, margin, margin));
        panel3.setBorder(new EmptyBorder(margin, margin, margin, margin));
    }

    // Method to add a player type combo box
    protected void addComboType() {
        JLabel playerTypLabel = new JLabel("Player Type:");
        JComboBox<String> typesCombo = new JComboBox<String>();

        typesCombo.addItem("Beginner");
        typesCombo.addItem("Amateur");
        typesCombo.addItem("Professional");
        typesCombo.setSelectedItem("Amateur");

        // Adjusting the layout to accommodate the combo box
        topPanel.setLayout(new GridLayout(5, 2, 5, 5));
        topPanel.add(playerTypLabel);
        topPanel.add(typesCombo);
    }

    // Method to add the note section with a scrollable text area
    protected void noteComponent() {
        JLabel noteLabel = new JLabel("Note:");

        // ScrollPane Config
        JTextArea txtArea = new JTextArea(3, 35);
        txtArea.setText(
                "Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.\n");
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtArea);

        // Panel for the note section
        notePanel = new JPanel(new GridLayout(2, 1, -10, -10));
        notePanel.add(noteLabel);
        notePanel.add(scrollPane);
    }

    // Overridden method to add components to the contentPane
    @Override
    protected void addComponents(Container contentPane) {
        addTopPanelComponents();
        addComboType();
        noteComponent();
        confirmButtons();
        // Add Panel to ContentPane
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(topPanel, 0);
        contentPane.add(notePanel, 1);
        contentPane.add(buttonPanel, 2);
        JPanel[] setPanel = { topPanel, notePanel, buttonPanel };
        setMargin(setPanel, 7);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
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

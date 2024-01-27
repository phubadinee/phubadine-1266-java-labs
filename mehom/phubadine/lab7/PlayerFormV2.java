package mehom.phubadine.lab7;

import javax.swing.*;
import java.awt.*;


public class PlayerFormV2 extends PlayerFormV1 {
    static JPanel largPanel;

    public PlayerFormV2(String title) {
        super(title);
    }

    protected void addLastComponent() {
        JLabel playerTypLabel = new JLabel("Player Type:");
        JComboBox<String> typesCombo = new JComboBox<String>();

        typesCombo.addItem("Beginner");
        typesCombo.addItem("Amateur");
        typesCombo.addItem("Professional");
        typesCombo.setSelectedItem("Amateur");
        topPanel.setLayout(new GridLayout(6, 2, 5, 5));
        topPanel.add(playerTypLabel);
        topPanel.add(typesCombo);
        JLabel noteLabel = new JLabel("Note:");
        topPanel.add(noteLabel);
    }

    @Override
    protected void addComponents(Container contentPane) { 
        
        JTextArea txtArea = new JTextArea(3, 35);
        txtArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtArea);

        topPanelComponents();
        addLastComponent();
        confirmButtons();
        
        // Add Panel to ContentPane
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH); 
    }

    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
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

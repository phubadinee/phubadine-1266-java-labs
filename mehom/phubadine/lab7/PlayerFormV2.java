package mehom.phubadine.lab7;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class PlayerFormV2 extends PlayerFormV1 {

    JPanel notePanel;

    public PlayerFormV2(String title) {
        super(title);
    }

    protected void setMargin(JPanel panel1, JPanel panel2, JPanel panel3, int margin) {
        panel1.setBorder(new EmptyBorder(margin, margin, margin, margin));
        panel2.setBorder(new EmptyBorder(margin, margin, margin, margin));
        panel3.setBorder(new EmptyBorder(margin, margin, margin, margin));
    }

    protected void addComboType() {
        JLabel playerTypLabel = new JLabel("Player Type:");
        JComboBox<String> typesCombo = new JComboBox<String>();

        typesCombo.addItem("Beginner");
        typesCombo.addItem("Amateur");
        typesCombo.addItem("Professional");
        typesCombo.setSelectedItem("Amateur");

        topPanel.setLayout(new GridLayout(5, 2, 5, 5));
        topPanel.add(playerTypLabel);
        topPanel.add(typesCombo);
    }

    protected void noteComponent() {
        JLabel noteLabel = new JLabel("Note:");

        // ScrollPane Config
        JTextArea txtArea = new JTextArea(3, 35);
        txtArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.\n");
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtArea);

        notePanel = new JPanel(new BorderLayout());
        notePanel.add(noteLabel, BorderLayout.WEST);
        notePanel.add(scrollPane, BorderLayout.SOUTH);
    }
    @Override
    protected void addComponents(Container contentPane) { 

        configFormLabel();
        configFormTextField();
        addTopPanelComponents();
        addComboType();
        noteComponent();
        confirmButtons();

        setMargin(topPanel, buttonPanel, notePanel, 7);
        
        // Add Panel to ContentPane
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(notePanel, BorderLayout.CENTER);
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

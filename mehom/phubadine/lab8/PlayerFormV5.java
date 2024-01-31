package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV5 extends PlayerFormV4 {
    JPanel footballPanel;
    ImageIcon footballImg = new ImageIcon("mehom\\phubadine\\lab8\\img\\Football.jpg");
    ImageIcon newMenuIcon = new ImageIcon("mehom\\phubadine\\lab8\\img\\New-icon.png");
    ImageIcon openMenuIcon = new ImageIcon("mehom\\phubadine\\lab8\\img\\Open-icon.png");
    ImageIcon saveMenuIcon = new ImageIcon("mehom\\phubadine\\lab8\\img\\Save-icon.png");

    public PlayerFormV5(String title) {
        super(title);
    }

    protected void addImage(){
        footballPanel = new JPanel();
        footballPanel.add(new JLabel(footballImg));
    }

    @Override
    protected void addComponents(Container contentPane) {
        addMenus();
        addTopPanelComponents();
        addComboType();
        addHobbies();
        addSportList();
        addSlider();
        noteComponent();
        addImage();
        confirmButtons();

        // Add Panel to ContentPane
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(topPanel);
        contentPane.add(hobbiesPanel);
        contentPane.add(sportPanel);
        contentPane.add(sliderPanel);
        contentPane.add(notePanel);
        contentPane.add(footballPanel);
        contentPane.add(buttonPanel);
        JPanel[] setPanel = {topPanel, hobbiesPanel, sportPanel, sliderPanel, notePanel, buttonPanel};
        setMargin(setPanel, 7);
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");    
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

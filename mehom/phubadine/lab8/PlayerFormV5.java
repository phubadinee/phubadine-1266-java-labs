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
    protected void addMenus() {
        // Intialize Menu
        menuBar = new JMenuBar();     
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        menuBar.add(fileMenu);
        menuBar.add(configMenu);

        // File Menu
        JMenuItem newItem = new JMenuItem("New", newMenuIcon);
        JMenuItem openItem = new JMenuItem("Open", openMenuIcon);
        JMenuItem saveItem = new JMenuItem("Save", saveMenuIcon);
        JSeparator separator = new JSeparator();
        JMenuItem ExitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(separator);
        fileMenu.add(ExitItem);

        // Color Config
        colorConfig = new JMenu("Color");

        String[] colorObject = {"Red", "Green", "Blue"};
        for (int range = 0 ; range< colorObject.length; range++) {
            JMenuItem size = new JMenuItem(colorObject[range]);
            colorConfig.add(size);
        }

        // Size Config
        sizeConfig = new JMenu("Size");
        for (int range = 0 ; range<3 ; range++) {
            int intSize = 16 + (4*range);
            JMenuItem size = new JMenuItem(Integer.toString(intSize));
            sizeConfig.add(size);
        }
        
        configMenu.add(colorConfig);
        configMenu.add(sizeConfig);
        setJMenuBar(menuBar);
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

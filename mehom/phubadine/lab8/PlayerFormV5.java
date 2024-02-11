package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PlayerFormV5 extends PlayerFormV4 {
    JPanel footballPanel;
    ReadImage footballImg = new ReadImage("mehom\\phubadine\\lab8\\img\\Football.jpg");
    ImageIcon newMenuIcon = new ImageIcon("mehom\\phubadine\\lab8\\img\\New-icon.png");
    ImageIcon openMenuIcon = new ImageIcon("mehom\\phubadine\\lab8\\img\\Open-icon.png");
    ImageIcon saveMenuIcon = new ImageIcon("mehom\\phubadine\\lab8\\img\\Save-icon.png");

    public PlayerFormV5(String title) {
        super(title);
    }

    protected void addImage(){
        footballPanel = new JPanel();
        footballImg.setPreferredSize(new Dimension(400, 200)); 
        footballPanel.add(footballImg);
    }

    @Override
    protected void addMenus() {
        super.addMenus();
        menuBar.remove(0);
        fileMenu = new JMenu("File");
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
        menuBar.add(fileMenu, 0);
    }

    @Override
    protected void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        addMenus();
        addImage();
        contentPane.add(footballPanel, 5);
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

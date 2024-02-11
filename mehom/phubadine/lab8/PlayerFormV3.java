package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;

import mehom.phubadine.lab7.PlayerFormV2;

public class PlayerFormV3 extends PlayerFormV2 {

    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, colorConfig, sizeConfig;

    public PlayerFormV3(String title) {
        super(title);
    }

    protected void addMenus() {
        // Intialize Menu
        menuBar = new JMenuBar();     
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        menuBar.add(fileMenu);
        menuBar.add(configMenu);

        // File Menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
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
        super.addComponents(contentPane);
        addMenus();
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
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

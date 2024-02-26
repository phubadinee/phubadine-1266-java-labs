package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.EmptyBorder;
import mehom.phubadine.lab7.PlayerFormV2;

/* 
 * The code defines a Swing GUI application, an extension of PlayerFormV2, named PlayerFormV3. 
 * It includes menu bars with "File" and "Config" menus, submenus for file operations, and configuration options 
 * for color and size. The main method initializes and displays the GUI using SwingUtilities.invokeLater.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV3 extends PlayerFormV2 {
    
    // Declare menu components
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, colorConfig, sizeConfig;
    protected JMenuItem newItem, openItem, saveItem, ExitItem, redColor, greenColor, blueColor, size16, size20, size24;
    protected JSeparator separator;
    public PlayerFormV3(String title) {
        super(title);
    }
    
    // Add menus to the form
    protected void addMenus() {
        // Intialize Menu
        menuBar = new JMenuBar();     
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        menuBar.add(fileMenu);
        menuBar.add(configMenu);

        // File Menu
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        separator = new JSeparator();
        ExitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(separator);
        fileMenu.add(ExitItem);

        // Color Config
        colorConfig = new JMenu("Color");
        redColor = new JMenuItem("Red");
        greenColor = new JMenuItem("Green");
        blueColor = new JMenuItem("Blue");
        colorConfig.add(redColor);
        colorConfig.add(greenColor);
        colorConfig.add(blueColor);
        

        // Size Config
        sizeConfig = new JMenu("Size");
        size16 = new JMenuItem(Integer.toString(16));
        size20 = new JMenuItem(Integer.toString(20));
        size24 = new JMenuItem(Integer.toString(24));
        sizeConfig.add(size16);
        sizeConfig.add(size20);
        sizeConfig.add(size24);
        
        configMenu.add(colorConfig);
        configMenu.add(sizeConfig);
        setJMenuBar(menuBar);
    }

    // Override method to add menus to the form
    @Override
    protected void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        addMenus();
    }
    
    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
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

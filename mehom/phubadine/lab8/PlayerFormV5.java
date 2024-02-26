package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/* 
 * The code defines a Swing GUI application, PlayerFormV5, extending PlayerFormV4. 
 * It adds a panel for displaying a football image and customizes file menu icons. 
 * The GUI includes checkboxes for hobbies, a list for sports, a slider for experience, 
 * and an image panel for football. The main method initializes and displays the GUI using 
 * SwingUtilities.invokeLater.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV5 extends PlayerFormV4 {
    
    // Declare an additional panel and image for football
    protected JPanel footballPanel;
    protected JMenuItem newItem, openItem, saveItem, ExitItem;
    protected ReadImage footballImg = new ReadImage("mehom\\phubadine\\img\\Football.jpg");
    protected ImageIcon newMenuIcon = new ImageIcon("mehom\\phubadine\\img\\New-icon.png");
    protected ImageIcon openMenuIcon = new ImageIcon("mehom\\phubadine\\img\\Open-icon.png");
    protected ImageIcon saveMenuIcon = new ImageIcon("mehom\\phubadine\\img\\Save-icon.png");

    // Declare an additional panel and image for football
    public PlayerFormV5(String title) {
        super(title);
    }

   // Add an image panel for football
    protected void addImage(){
        footballPanel = new JPanel();
        footballImg.setPreferredSize(new Dimension(400, 200)); 
        footballPanel.add(footballImg);
    }

    // Override method to customize file menu icons
    @Override
    protected void addMenus() {
        super.addMenus();
        menuBar.remove(0);
        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New", newMenuIcon);
        openItem = new JMenuItem("Open", openMenuIcon);
        saveItem = new JMenuItem("Save", saveMenuIcon);
        JSeparator separator = new JSeparator();
        ExitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(separator);
        fileMenu.add(ExitItem);
        menuBar.add(fileMenu, 0);
    }

    // Override method to add new components to the form
    @Override
    protected void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        addMenus();
        addImage();
        contentPane.add(footballPanel, 5);
        JPanel[] setPanel = {footballPanel};
        setMargin(setPanel, 7);
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");    
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

package mehom.phubadine.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import javax.swing.*;
import java.awt.*;

import javax.swing.event.MenuListener;

/* 
 * The code defines a Swing GUI application (PlayerFormV11) extending a previous version (PlayerFormV10), 
 * adding functionality for custom color selection, file dialogs, and keyboard shortcuts. It can be launched 
 * through the main method using SwingUtilities.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV11 extends PlayerFormV10 {

    // Member variables for custom menu item, color chooser, and file chooser
    protected JMenuItem customItem;
    protected JColorChooser tcc;
    protected JFileChooser fc;

    // Constructor
    public PlayerFormV11(String title) {
        super(title);
    }

    // Override method to add action listeners for new menu items
    @Override
    public void addListeners() {
        super.addListeners();
        customItem.addActionListener(this);
        ExitItem.addActionListener(this);
    }
    
    // Override method to add new menu items
    @Override
    public void addMenus() {
        super.addMenus();
        customItem = new JMenuItem("Custom");
        colorConfig.add(customItem);
    }

    // Override method to handle action events
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JMenuItem src = (JMenuItem) e.getSource();

        // Check which new menu item is selected and call corresponding handling methods
        if (src == customItem) {
            Color colorChoosed = JColorChooser.showDialog(this,"Select a color", Color.BLACK);
            super.handleColorMenu(colorChoosed);
        }  else if (src == ExitItem) {
            System.exit(0);
        }
    }

    // Method to set mnemonic and accelerator keys for menu items
    public void setMAKeys(JMenuItem menuItem, int mKey, int aKey) {
        menuItem.setMnemonic(mKey);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(aKey, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    // Method to enable keyboard shortcuts
    public void enableKeyboard() {
        fileMenu.setMnemonic(KeyEvent.VK_F);
        setMAKeys(newItem, KeyEvent.VK_N, KeyEvent.VK_N);
        setMAKeys(openItem, KeyEvent.VK_O, KeyEvent.VK_O);
        setMAKeys(saveItem, KeyEvent.VK_S, KeyEvent.VK_S);
        setMAKeys(ExitItem, KeyEvent.VK_Q, KeyEvent.VK_Q);
    }

    // Override method to handle file menu items with file dialogs
    @Override 
    public void handleFileMenu(JMenuItem fileItem) {
        super.handleFileMenu(fileItem);
        fc = new JFileChooser();
        if (fileItem == openItem) {
            int returnVal = fc.showOpenDialog(PlayerFormV11.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Opening file " + file.getAbsolutePath()); 
            } 
        } else if (fileItem == saveItem) {
            int returnVal = fc.showSaveDialog(PlayerFormV11.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Saving in file " + file.getAbsolutePath()); 
            } 
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.enableKeyboard();
        msw.addListeners();
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

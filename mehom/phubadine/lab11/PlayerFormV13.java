package mehom.phubadine.lab11;

import java.io.*;
import javax.swing.*;

import mehom.phubadine.lab10.PlayerFormV11;

/* 
 * The Java code defines a class PlayerFormV13 that extends PlayerFormV12, adding file handling methods 
 * to read and write data, and overrides the file menu handling method for opening and saving files. 
 * The main method launches a Swing GUI application for a player form with version 13.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

// PlayerFormV13 class extending PlayerFormV12
public class PlayerFormV13 extends PlayerFormV12 {

    // Constructor for PlayerFormV13
    public PlayerFormV13(String title) {
        super(title);
    }

    // Method to handle opening a file and displaying its content
    public void openFileHandle(JFileChooser fc) {
        File file = fc.getSelectedFile();
        String filePath = file.getAbsolutePath();
        JOptionPane.showMessageDialog(this, "Opening file " + file.getAbsolutePath()); 

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader r = new BufferedReader(fr);
            String line;
            String res = "";
            while ((line = r.readLine()) != null) {
                // System.out.print(line);
                res += line;
            }
            r.close();
            fr.close();
            JOptionPane.showMessageDialog(this, "Data read from file " + file.getAbsolutePath() + " is \n"
            + res); 
        }  catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    // Method to handle writing data to a file
    public void writeFileHandle(JFileChooser fc) {
        File file = fc.getSelectedFile();
        String filePath = file.getAbsolutePath();

        try {
            PrintWriter p = new PrintWriter(new FileWriter(filePath));
            p.print(getValue());
            p.close();
            JOptionPane.showMessageDialog(this, "Saving in file " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    
    // Override method to handle file menu actions  
    @Override 
    public void handleFileMenu(JMenuItem fileItem) {
        // super.handleFileMenu(fileItem);
        fc = new JFileChooser();
        if (fileItem == openItem) {
            int returnVal = fc.showOpenDialog(PlayerFormV13.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                openFileHandle(fc);
            } 
        } else if (fileItem == saveItem) {
            int returnVal = fc.showSaveDialog(PlayerFormV13.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                writeFileHandle(fc);   
            } 
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV13 msw = new PlayerFormV13("Player Form V13");
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

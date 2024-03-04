package mehom.phubadine.lab11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mehom.phubadine.lab10.PlayerFormV11;

public class PlayerFormV13 extends PlayerFormV12 {

    public PlayerFormV13(String title) {
        super(title);
    }

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
            JOptionPane.showMessageDialog(this, "Data read from file " + file.getAbsolutePath() + "\n"
            + res); 
        }  catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

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

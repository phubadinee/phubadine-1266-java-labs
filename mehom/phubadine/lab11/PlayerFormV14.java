package mehom.phubadine.lab11;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerFormV14 extends PlayerFormV13{

    protected JMenu fillMenu;
    protected JRadioButtonMenuItem yesRadioMenuItem, noRadioMenuItem;

    public PlayerFormV14(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        yesRadioMenuItem.addItemListener(this);
        noRadioMenuItem.addItemListener(this);

    }

    @Override
    public void addMenus() {
        super.addMenus();
        fillMenu = new JMenu("Fill");

        ButtonGroup fillStateMenuItem = new ButtonGroup();
        yesRadioMenuItem = new JRadioButtonMenuItem("Yes");
        noRadioMenuItem = new JRadioButtonMenuItem("No", true);

        fillStateMenuItem.add(yesRadioMenuItem);
        fillStateMenuItem.add(noRadioMenuItem);

        fillMenu.add(yesRadioMenuItem);
        fillMenu.add(noRadioMenuItem);
        menuBar.add(fillMenu);

    }

    // @Override 
    // public void itemStateChanged(ItemEvent e) {
    //     super.itemStateChanged(e);
    //     Object src = e.getSource();
    //     System.out.println("state");
    //     JRadioButtonMenuItem eventSource = (JRadioButtonMenuItem) e.getSource();
    //     System.out.println("State");
    //     if (eventSource.isSelected()) {
    //         System.out.println(eventSource.getText());
    //     }
    // }

    @Override
    public void itemStateChanged(ItemEvent e) {
        super.itemStateChanged(e);
        Object src = e.getSource();
        if ((src == yesRadioMenuItem || src == noRadioMenuItem) && e.getStateChange() == ItemEvent.SELECTED) {
           JRadioButtonMenuItem eventSource = (JRadioButtonMenuItem) e.getSource();
            if (eventSource.isSelected()) {
                String fillState = eventSource.getText();
                handleFillMenu(fillState);
            }
        }
    }

    public void handleFillMenu(String fillState) {
        if (fillState.equals("Yes")) {
            Player player = new Player();
            System.out.println("Fill - Yes ");
        } else if (fillState.equals("No")) {
            System.err.println("Fill - No");
        }
    }


    @Override 
    public void handleFileMenu(JMenuItem fileItem) {
        // super.handleFileMenu(fileItem);
        fc = new JFileChooser();
        if (fileItem == openItem) {
            int returnVal = fc.showOpenDialog(PlayerFormV14.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
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
                    System.err.println("Error saving content to the file: " + e.getMessage());
                }
            } 

        } else if (fileItem == saveItem) {
            int returnVal = fc.showSaveDialog(PlayerFormV14.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String filePath = file.getAbsolutePath();

                try {
                    PrintWriter p = new PrintWriter(new FileWriter(filePath));
                    p.print(getValue());
                    p.close();
                    JOptionPane.showMessageDialog(this, "Saving in file " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.err.println("Error saving content to the file: " + e.getMessage());
                }
                 
            } 
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
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

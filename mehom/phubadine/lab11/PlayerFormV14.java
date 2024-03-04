package mehom.phubadine.lab11;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    protected int toggleFill;

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

    public void openFileHandle(JFileChooser fc) {
        File file = fc.getSelectedFile();
        String filePath = file.getAbsolutePath();
        JOptionPane.showMessageDialog(this, "Opening file " + file.getAbsolutePath()); 

        try {
            // if (toggleFill == 1) {
                   
            // } else {
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
            // }
            
            JOptionPane.showMessageDialog(this, "Data read from file " + file.getAbsolutePath() + "\n"
            + res); 
        }  catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void writeFileHandle(JFileChooser fc) {
        File file = fc.getSelectedFile();
        String filePath = file.getAbsolutePath();
        try {
            if (toggleFill == 1) {
                Player player = new Player();
                player.setName(name);
                player.setNationality(nationality);
                player.setDob(birth);
                player.setPlayerType(playerType);
                player.setHobbies(hobbies);
                player.setSports(sports);

                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(player);
                oos.close();
                fos.close();
            } else {
                PrintWriter p = new PrintWriter(new FileWriter(filePath));
                p.print(getValue());
                p.close();
            }
            JOptionPane.showMessageDialog(this, "Saving in file " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

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
            System.out.println("1");
            toggleFill = 1;
        } else if (fillState.equals("No")) {
            System.out.println("0");
            toggleFill = 0;
        }
    }


    @Override 
    public void handleFileMenu(JMenuItem fileItem) {
        // super.handleFileMenu(fileItem);
        fc = new JFileChooser();
        if (fileItem == openItem) {
            int returnVal = fc.showOpenDialog(PlayerFormV14.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                openFileHandle(fc);
            } 
        } else if (fileItem == saveItem) {
            int returnVal = fc.showSaveDialog(PlayerFormV14.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                writeFileHandle(fc); 
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

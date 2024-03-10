package mehom.phubadine.lab11;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/* 
 * The Java code defines a class PlayerFormV14 extending PlayerFormV13, introducing radio menu items for 
 * filling form data based on file content, and overrides file handling methods to read and write data 
 * accordingly. The main method launches a Swing GUI application for a player form with version 14.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

// PlayerFormV14 class extending PlayerFormV13
public class PlayerFormV14 extends PlayerFormV13 {

    // Additional menu items and variables for filling form
    protected JMenu fillMenu;
    protected JRadioButtonMenuItem yesRadioMenuItem, noRadioMenuItem;
    protected int toggleFill;

    // Player object to store player information
    protected Player player;

    // Constructor for PlayerFormV14
    public PlayerFormV14(String title) {
        super(title);
    }

    // Override method to add listeners, including the new radio menu items
    @Override
    public void addListeners() {
        super.addListeners();
        yesRadioMenuItem.addItemListener(this);
        noRadioMenuItem.addItemListener(this);
    }

    // Override method to add menus, including the new "Fill" menu
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

    // Method to fill the form with player data
    public void fillForm(Player player) {
        nameTextField.setText(player.getName());
        nationalityTextField.setText(player.getNationality());
        dataOfBirthTextField.setText(player.getDob());

        if (player.getGenderResult().equals("Male")) {
            maleRadioButton.setSelected(true);
        } else {
            femaleRadioButton.setSelected(true);
        }

        typesCombo.setSelectedIndex(player.getPlayerIndex());  

        String[] hobbiesSplit = player.getHobbies().split(" ");
        for (String checkBox : hobbiesSplit) {
            
            sleepingCheckBox.setSelected(false);

            if (checkBox.equals("Reading")) {
                readingCheckBox.setSelected(true);
            } else if (checkBox.equals("Browsing")) {
                browsingCheckBox.setSelected(true);
            } else if (checkBox.equals("Sleeping")) {
                sleepingCheckBox.setSelected(true);
            } else if (checkBox.equals("Traveling")) {
                travelingCheckBox.setSelected(true);
            }
        }
        sportList.setSelectedIndices(player.getSportIndex()); 
        yearSlider.setValue(player.getYear());
    }

    // Override method to handle opening a file and display its content based on
    public void openFileHandle(JFileChooser fc) {
        File file = fc.getSelectedFile();
        String filePath = file.getAbsolutePath();
        JOptionPane.showMessageDialog(this, "Opening file " + file.getAbsolutePath());

        if (toggleFill == 1) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                player = (Player) ois.readObject();
                JOptionPane.showMessageDialog(this,
                        "Data read from file " + file.getAbsolutePath() + " is \n" + player);
                fillForm(player);
                ois.close();
                fis.close();
            } catch (ClassNotFoundException classNotFoundEx) {
                classNotFoundEx.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }

        } else {
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
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    // Override method to handle writing data to a file based on fill state
    @Override
    public void writeFileHandle(JFileChooser fc) {
        File file = fc.getSelectedFile();
        String filePath = file.getAbsolutePath();
        try {
            if (toggleFill == 1) {
                getValue();
                int playerIndex = typesCombo.getSelectedIndex();
                player = new Player(name, nationality, birth, playerType, playerIndex, genderResult, hobbies,
                        sportIndex, value, sports);

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

    // Override method to handle item state change for radio menu items
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

    // Method to handle changing the fill state based on user selection
    public void handleFillMenu(String fillState) {
        if (fillState.equals("Yes")) {
            toggleFill = 1;
        } else if (fillState.equals("No")) {
            toggleFill = 0;
        }
    }

    // Override method to handle file menu actions
    @Override
    public void handleFileMenu(JMenuItem fileItem) {
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

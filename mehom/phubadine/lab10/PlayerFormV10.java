package mehom.phubadine.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuListener;

public class PlayerFormV10 extends PlayerFormV9 implements ActionListener {
    
    public PlayerFormV10(String title) {
        super(title);
    }
    
    @Override
    public void addListeners() {
        super.addListeners();
        redColor.addActionListener(this);
        greenColor.addActionListener(this);
        blueColor.addActionListener(this);
        size16.addActionListener(this);
        size20.addActionListener(this);
        size24.addActionListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JMenuItem src = (JMenuItem) e.getSource();
        if (src == redColor) {
            handleColorMenu(Color.RED);
        } else if (src == greenColor) {
            handleColorMenu(Color.GREEN);
        } else if (src == blueColor) {
            handleColorMenu(Color.BLUE);
        } else if (src == size16 || src == size20 || src == size24) {
            JMenuItem sizeItem = (JMenuItem) e.getSource();
            handleSizeMenu(sizeItem);
        }
    }

    public void handleSizeMenu(JMenuItem sizeItem) {
        int valueSize = Integer.parseInt(sizeItem.getText());
        txtArea.setFont(new Font("Serif",Font.TYPE1_FONT,valueSize));
    }

    public void handleColorMenu(Color color) {
        nameTextField.setForeground(color);
        nationalityTextField.setForeground(color);
        dataOfBirthTextField.setForeground(color);
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
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

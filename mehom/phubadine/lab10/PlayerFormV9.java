package mehom.phubadine.lab10;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {
    
    public PlayerFormV9(String title) {
        super(title);
    }

    @Override 
    public void addListeners() {
        super.addListeners();
        yearSlider.addChangeListener(this);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider src = (JSlider) e.getSource();
        boolean adjust = src.getValueIsAdjusting();
        if (!adjust) {
            int value = yearSlider.getValue();
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + value); 
        }
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
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

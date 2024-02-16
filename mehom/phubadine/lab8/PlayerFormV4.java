package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;

/* 
 * The code defines a Swing GUI application, PlayerFormV4, extending PlayerFormV3. 
 * It introduces additional panels for hobbies, sports, and a slider for years of experience. 
 * The GUI includes checkboxes for hobbies, a list for sports, and a slider for experience. 
 * The main method initializes and displays the GUI using SwingUtilities.invokeLater.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PlayerFormV4 extends PlayerFormV3 {
    
    // Declare additional panels and slider
    protected JPanel hobbiesPanel, sportPanel, sliderPanel;
    protected JList sportList;
    protected JSlider yearSlider;
    protected JCheckBox readingCheckBox, browsingCheckBox, sleepingCheckBox, travelingCheckBox;
    // Constructor initializes the PlayerFormV4
    public PlayerFormV4(String title) {
        super(title);
    }

    // Add hobby components to the form
    protected void addHobbies() {
        hobbiesPanel = new JPanel();
        hobbiesPanel.setLayout(new GridLayout(2,1));

        JLabel hobbiesJLabel = new JLabel("Hobbies:");
        
        // Create checkboxes for different hobbies
        JPanel checkBoxGroup = new JPanel();
        checkBoxGroup.setLayout(new FlowLayout());
        readingCheckBox = new JCheckBox("Reading");
        browsingCheckBox = new JCheckBox("Browsing");
        sleepingCheckBox = new JCheckBox("Sleeping", true);
        travelingCheckBox = new JCheckBox("Traveling");
        checkBoxGroup.add(readingCheckBox);
        checkBoxGroup.add(browsingCheckBox);
        checkBoxGroup.add(sleepingCheckBox);
        checkBoxGroup.add(travelingCheckBox);

        // Add components to the hobbies panel
        hobbiesPanel.add(hobbiesJLabel);
        hobbiesPanel.add(checkBoxGroup);
    }    

    // Add sport list components to the form
    @SuppressWarnings("unchecked")
    protected void addSportList() {
        JLabel sportLabel = new JLabel("Sport:");

        // Create a list of sports
        String sport[]= {"Badminton", "Boxing", "Football", "Running"};
        sportList = new JList(sport);
        sportList.setSelectedIndex(2);

        // Add components to the sport panel
        sportPanel = new JPanel();
        sportPanel.setLayout(new GridLayout(1, 2));
        sportPanel.add(sportLabel);
        sportPanel.add(sportList);
    }

    // Add slider components to the form
    protected void addSlider() {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(2, 1));

        JLabel yearExperienceOfSport = new JLabel("Year of experience in this sport:");
        
        // Create a slider for year of experience
        yearSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);  
        yearSlider.setMinorTickSpacing(1);  
        yearSlider.setMajorTickSpacing(5);  
        yearSlider.setPaintTicks(true);  
        yearSlider.setPaintLabels(true);  

        // Add components to the slider panel
        sliderPanel.add(yearExperienceOfSport);
        sliderPanel.add(yearSlider);
    }
    
    // Override method to add new components to the form
    @Override
    protected void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        addHobbies();
        addSportList();
        addSlider();
        
        // Add new panels to the content pane
        contentPane.add(hobbiesPanel, 1);
        contentPane.add(sportPanel, 2);
        contentPane.add(sliderPanel, 3);
        JPanel[] setPanel = { hobbiesPanel, sportPanel, sliderPanel };
        setMargin(setPanel, 7);
    }

    // Create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");    
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

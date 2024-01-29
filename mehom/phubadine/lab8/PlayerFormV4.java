package mehom.phubadine.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JPanel hobbiesPanel, sportPanel, sliderPanel;
    protected JSlider yearSlider;

    public PlayerFormV4(String title) {
        super(title);
    }

    protected void addHobbies() {
        hobbiesPanel = new JPanel();
        hobbiesPanel.setLayout(new GridLayout(2,1));

        JLabel hobbiesJLabel = new JLabel("Hobbies:");
        
        JPanel checkBoxGroup = new JPanel();
        checkBoxGroup.setLayout(new FlowLayout());
        JCheckBox readingCheckBox = new JCheckBox("Reading");
        JCheckBox browsingCheckBox = new JCheckBox("Browsing");
        JCheckBox sleepingCheckBox = new JCheckBox("Sleeping", true);
        JCheckBox travelingCheckBox = new JCheckBox("Traveling");
        checkBoxGroup.add(readingCheckBox);
        checkBoxGroup.add(browsingCheckBox);
        checkBoxGroup.add(sleepingCheckBox);
        checkBoxGroup.add(travelingCheckBox);

        hobbiesPanel.add(hobbiesJLabel);
        hobbiesPanel.add(checkBoxGroup);
    }    

    @SuppressWarnings("unchecked")
    protected void addSportList() {
        JLabel sportLabel = new JLabel("Sport:");

        String sport[]= {"Badminton", "Boxing", "Football", "Running"};
        JList sportList = new JList(sport);
        sportList.setSelectedIndex(2);

        sportPanel = new JPanel();
        sportPanel.setLayout(new GridLayout(1, 2));
        sportPanel.add(sportLabel);
        sportPanel.add(sportList);
    }

    protected void addSlider() {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(2, 1));

        JLabel yearExperienceOfSport = new JLabel("Year of experience in this sport:");
        yearSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);  
        yearSlider.setMinorTickSpacing(2);  
        yearSlider.setMajorTickSpacing(5);  
        yearSlider.setPaintTicks(true);  
        yearSlider.setPaintLabels(true);  

        sliderPanel.add(yearExperienceOfSport);
        sliderPanel.add(yearSlider);
    }
    
    @Override
    protected void addComponents(Container contentPane) {
        addMenus();
        addTopPanelComponents();
        addComboType();
        addHobbies();
        addSportList();
        addSlider();
        noteComponent();
        confirmButtons();

        // Add Panel to ContentPane
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(topPanel);
        contentPane.add(hobbiesPanel);
        contentPane.add(sportPanel);
        contentPane.add(sliderPanel);
        contentPane.add(notePanel);
        contentPane.add(buttonPanel);
        JPanel[] setPanel = {topPanel, hobbiesPanel, sportPanel, sliderPanel, notePanel, buttonPanel};
        setMargin(setPanel, 7);
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");    
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    
}

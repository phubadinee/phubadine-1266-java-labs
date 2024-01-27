package mehom.phubadine.lab7;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MySimpleWindow extends JFrame {
    protected static JPanel buttonPanel, mainPanel;
    protected JButton resetButton, submitButton;


    public MySimpleWindow(String title) {
        super(title);
    }

    protected void addComponents(Container contentPane) {
        buttonPanel = new JPanel();

        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        contentPane.setLayout(new FlowLayout());
        contentPane.add(buttonPanel);
    }

    public void setFrameFeatures() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        mainPanel = new JPanel();
        msw.addComponents(mainPanel);
        msw.setContentPane(mainPanel);
        msw.setFrameFeatures();
        msw.setSize(300, 80);
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

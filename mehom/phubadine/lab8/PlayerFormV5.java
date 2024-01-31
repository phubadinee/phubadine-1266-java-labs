package mehom.phubadine.lab8;

import javax.swing.SwingUtilities;

public class PlayerFormV5 extends PlayerFormV4 {

    public PlayerFormV4(String title) {
        super(title);
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

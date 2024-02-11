package mehom.phubadine.lab8;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReadImage extends JPanel {
    private Image image;

    public ReadImage(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image on the form
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}

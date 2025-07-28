import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class ImageApplet extends Applet {
    Image img;

    public void init() {
        try {
            // Load image from the same directory as the applet
            URL imageURL = new URL(getCodeBase(), "image.jpg");
            img = getImage(imageURL);
        } catch (Exception e) {
            System.out.println("Image not found.");
        }
    }

    public void paint(Graphics g) {
        if (img != null) {
            g.drawImage(img, 10, 10, this);
        } else {
            g.drawString("Image not loaded", 10, 10);
        }
    }
}

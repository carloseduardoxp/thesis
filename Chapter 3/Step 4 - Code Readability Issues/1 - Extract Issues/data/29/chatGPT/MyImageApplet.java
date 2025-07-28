import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class MyImageApplet extends Applet {
    private Image image;

    @Override
    public void init() {
        // Get the URL of the image
        URL imageURL = getClass().getResource("my_image.png");

        // Load the image from the URL
        image = getImage(imageURL);
    }

    @Override
    public void paint(Graphics g) {
        // Draw the image on the applet
        g.drawImage(image, 0, 0, this);
    }
}

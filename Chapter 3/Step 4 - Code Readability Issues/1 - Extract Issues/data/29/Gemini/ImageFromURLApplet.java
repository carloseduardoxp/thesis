import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class ImageFromURLApplet extends Applet {

    private Image image;
    private URL imageURL;
    private String imagePath = "https://www.easygifanimator.net/images/samples/video-to-gif-sample.gif"; // Replace with your image URL

    @Override
    public void init() {
        try {
            imageURL = new URL(getCodeBase(), imagePath);
            image = getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., display an error message
        }
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        } else {
            g.drawString("Image not loaded.", 10, 25);
        }
    }
}

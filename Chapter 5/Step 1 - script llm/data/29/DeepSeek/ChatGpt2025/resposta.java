import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class ImageLoaderApplet extends Applet {
    private Image image;

    @Override
    public void init() {
        // Get the image URL from applet parameters
        String imageUrl = getParameter("imageUrl");
        
        if (imageUrl != null) {
            try {
                URL url = new URL(imageUrl);
                image = getImage(url);
            } catch (Exception e) {
                showStatus("Error loading image: " + e.getMessage());
            }
        } else {
            showStatus("No image URL specified");
        }
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            // Draw the image at (0, 0)
            g.drawImage(image, 0, 0, this);
        } else {
            g.drawString("No image loaded", 20, 20);
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageDisplayExample {
    public static void main(String[] args) {
        try {
            // Load the image
            BufferedImage image = ImageIO.read(new File("path/to/your/image.jpg"));
            
            // Create a JFrame to display the image
            JFrame frame = new JFrame("Image Display");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            
            // Add the image to a JLabel
            JLabel label = new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            
            // Set frame size and make it visible
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
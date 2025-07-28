import javax.swing.*;
import java.awt.*;

public class ImageDisplay {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Image Display Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Load the image
        ImageIcon imageIcon = new ImageIcon("path/to/your/image.jpg");

        // Add the image to a label
        JLabel label = new JLabel(imageIcon);

        // Add the label to the frame
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}

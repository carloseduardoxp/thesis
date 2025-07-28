import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout; // For simple layout management

public class ImageDisplayExample {

    public static void main(String[] args) {
        // 1. Create a JFrame (the window)
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // Close operation

        // 2. Load the image using ImageIcon
        // Make sure "your_image.jpg" is in the same directory as your .java file,
        // or provide the full path to the image.
        ImageIcon imageIcon = new ImageIcon("your_image.jpg"); 

        // Check if the image loaded successfully (optional but good practice)
        if (imageIcon.getImageLoadStatus() == java.awt.MediaTracker.ERRORED) {
            System.err.println("Error loading image: your_image.jpg. Please check the file path and existence.");
            System.exit(1); // Exit if image not found/loaded
        }

        // 3. Create a JLabel and set the ImageIcon to it
        JLabel label = new JLabel(imageIcon);

        // 4. Add the JLabel to the JFrame
        frame.getContentPane().add(label); // Using getContentPane() is good practice

        // 5. Set the layout manager (FlowLayout for simplicity)
        frame.setLayout(new FlowLayout()); // This will arrange components in a row

        // 6. Pack the frame (adjusts size to fit components) and make it visible
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}

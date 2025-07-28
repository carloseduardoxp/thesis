import java.awt.*;
import javax.swing.*;

public class MultiMonitorExample {
    public static void main(String[] args) {
        // Get the graphics environment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        // Loop through all available screens
        for (int i = 0; i < screens.length; i++) {
            GraphicsDevice screen = screens[i];

            // Create a JFrame for this screen
            JFrame frame = new JFrame("Monitor #" + (i + 1));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setUndecorated(false); // Set to true if you want full screen

            // Get the bounds of this screen
            Rectangle bounds = screen.getDefaultConfiguration().getBounds();
            frame.setLocation(bounds.x + 50, bounds.y + 50); // Offset a bit from top-left

            frame.add(new JLabel("This is monitor #" + (i + 1), SwingConstants.CENTER), BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }
}

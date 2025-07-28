import javax.swing.*;
import java.awt.*;

public class TextAreaColorChange {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("JTextArea Color Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout()); // Simple layout for demonstration

        // Create the JTextArea
        JTextArea textArea = new JTextArea(10, 30); // 10 rows, 30 columns
        textArea.setText("This is a JTextArea. Its background color will be changed!");
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries

        // Change the background color
        // You can use predefined colors:
        // textArea.setBackground(Color.YELLOW);

        // Or create a custom color using RGB values:
        textArea.setBackground(new Color(200, 255, 200)); // A light green color

        // Optional: Change the foreground (text) color as well
        textArea.setForeground(Color.BLUE);

        // Add a scroll pane to the text area (good practice for JTextArea)
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Make the frame visible
        frame.setVisible(true);
    }
}

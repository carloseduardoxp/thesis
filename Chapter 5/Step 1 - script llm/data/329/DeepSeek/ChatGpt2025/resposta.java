import javax.swing.*;
import java.awt.*;

public class ColoredTextArea {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Colored TextArea Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Create a JTextArea
        JTextArea textArea = new JTextArea();
        
        // Set text color
        textArea.setForeground(Color.BLUE);
        
        // Set background color
        textArea.setBackground(Color.YELLOW);
        
        // Set font
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        
        textArea.setText("This text is blue on yellow background");
        
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }
}

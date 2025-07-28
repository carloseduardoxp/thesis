import javax.swing.*;
import java.awt.*;

public class TextAreaColorExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Change JTextArea Color");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea("This is some text.");
        
        // Change background color to light yellow
        textArea.setBackground(Color.YELLOW);
        
        // Change text color to red
        textArea.setForeground(Color.RED);

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

public class CheckboxExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Checkbox Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        
        // Create a checkbox
        JCheckBox checkBox = new JCheckBox("Enable Feature");
        
        // Set initial state (optional)
        checkBox.setSelected(true); // checked by default
        
        // Add action listener to handle state changes
        checkBox.addActionListener(e -> {
            JCheckBox source = (JCheckBox) e.getSource();
            System.out.println("Checkbox state: " + source.isSelected());
        });
        
        // Add checkbox to frame
        frame.add(checkBox);
        
        // Display the frame
        frame.setVisible(true);
    }
}

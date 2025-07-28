import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ItemEvent;

public class CheckboxExample {
    public static void main(String[] args) {
        // Create a JFrame (the window)
        JFrame frame = new JFrame("Checkbox Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout()); // Use FlowLayout for simplicity

        // Create a JCheckBox
        JCheckBox checkBox = new JCheckBox("Agree to Terms");

        // Add an ItemListener to respond to changes
        checkBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("Checkbox is checked!");
            } else {
                System.out.println("Checkbox is unchecked.");
            }
        });

        // Add the checkbox to the frame
        frame.add(checkBox);

        // Make the frame visible
        frame.setVisible(true);
    }
}

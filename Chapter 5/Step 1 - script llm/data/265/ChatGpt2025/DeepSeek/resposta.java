import javax.swing.*;

public class CheckboxExample {
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Checkbox Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null); // We'll set positions manually

        // Create a checkbox
        JCheckBox checkbox = new JCheckBox("Accept Terms and Conditions");
        checkbox.setBounds(50, 50, 200, 30); // Set position and size (x, y, width, height)

        // Add checkbox to the frame
        frame.add(checkbox);

        // Make frame visible
        frame.setVisible(true);
    }
}

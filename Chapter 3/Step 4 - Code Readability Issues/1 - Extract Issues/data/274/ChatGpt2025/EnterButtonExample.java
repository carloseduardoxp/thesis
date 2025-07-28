import javax.swing.*;

public class EnterButtonExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Enter Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a button
        JButton button = new JButton("Click Me");
        
        // Add an ActionListener to the button to define what happens when it's clicked
        button.addActionListener(e -> {
            System.out.println("Button clicked!");
        });

        // Create a KeyListener to detect the Enter key press
        frame.getRootPane().setDefaultButton(button); // Set the default button for Enter key press

        // Set up layout and add the button
        JPanel panel = new JPanel();
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }
}

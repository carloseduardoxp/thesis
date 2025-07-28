import javax.swing.*;
import java.awt.event.*;

public class EnterButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Enter Key Example");
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");
        
        // Button action
        button.addActionListener(e -> {
            System.out.println("Submitted: " + textField.getText());
        });
        
        // Make button respond to Enter key
        frame.getRootPane().setDefaultButton(button);
        
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
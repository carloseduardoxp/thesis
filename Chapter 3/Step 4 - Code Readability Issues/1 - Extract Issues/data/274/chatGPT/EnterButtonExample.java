import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterButtonExample extends JFrame implements ActionListener {
   private JButton button;
   private JTextField textField;

   public EnterButtonExample() {
      // Create a text field and a button
      textField = new JTextField(20);
      button = new JButton("OK");

      // Add an action listener to the button
      button.addActionListener(this);

      // Add the button to a panel
      JPanel panel = new JPanel();
      panel.add(button);

      // Add the panel and the text field to the frame
      add(textField, BorderLayout.CENTER);
      add(panel, BorderLayout.SOUTH);

      // Set the default button to the OK button
      getRootPane().setDefaultButton(button);

      // Set the size and the visibility of the frame
      setSize(300, 100);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      // Handle the button click
      System.out.println("Button clicked!");
   }

   public static void main(String[] args) {
      new EnterButtonExample();
   }
}

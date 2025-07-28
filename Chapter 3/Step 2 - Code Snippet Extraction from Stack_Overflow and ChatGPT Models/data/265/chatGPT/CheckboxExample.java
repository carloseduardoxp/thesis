import javax.swing.*;

public class CheckboxExample {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Checkbox Example");
      JCheckBox checkbox = new JCheckBox("Check me!");
      checkbox.setBounds(100, 100, 100, 50);
      frame.add(checkbox);
      frame.setSize(300, 300);
      frame.setLayout(null);
      frame.setVisible(true);

      checkbox.addActionListener(e -> {
        if (checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }
    });
    
   }
}

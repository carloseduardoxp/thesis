import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class ChangeButtonTextExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Text Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JButton button = new JButton("Click Me!");
        frame.add(button);

        // Change button text after 2 seconds (just for demonstration)
        new javax.swing.Timer(2000, e -> button.setText("Text Changed!")).start();

        frame.setVisible(true);
    }
}

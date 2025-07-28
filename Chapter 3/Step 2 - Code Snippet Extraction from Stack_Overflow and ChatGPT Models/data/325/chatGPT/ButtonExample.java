import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ButtonExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Button Example");
            JButton button = new JButton("Click Me!");

            button.addActionListener(e -> {
                button.setText("Clicked!");
            });

            frame.add(button);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

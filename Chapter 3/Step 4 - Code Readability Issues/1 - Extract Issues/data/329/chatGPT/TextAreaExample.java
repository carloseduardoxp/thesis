import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextAreaExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(10, 30);

        textArea.setBackground(Color.YELLOW); // set background color to yellow

        panel.add(textArea);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

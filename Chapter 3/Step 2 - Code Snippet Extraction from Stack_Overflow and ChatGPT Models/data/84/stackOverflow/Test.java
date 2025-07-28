
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Test {

    public static void main(String[] args) {
        JFrame j = new JFrame("TEST");

        JLabel label = new JLabel(" -> ");
        label.setFont(new Font("Monospaced", Font.PLAIN, 12));

        j.add(label);
        j.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        j.pack();
        j.setSize(j.getWidth() * 3, j.getHeight() * 3);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }
}

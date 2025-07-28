import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Teste {

    public static void main(String[] args) {        
        ImageIcon image = new ImageIcon("image/pic1.jpg");
        JLabel label = new JLabel("", image, SwingConstants.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add( label, BorderLayout.CENTER );
    }
}
import javax.swing.*;
import java.net.URL;

public class ImageLoader {
    public static void main(String[] args) {
        URL imageUrl = ImageLoader.class.getResource("/images/myimage.png");
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label, "Image", JOptionPane.PLAIN_MESSAGE);
        } else {
            System.out.println("Image not found!");
        }
    }
}

import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageLoader {
    public static void main(String[] args) {
        try {
            // For ImageIcon
            ImageIcon icon = new ImageIcon(ImageLoader.class.getResource("/images/myimage.png"));
            
            // For BufferedImage
            InputStream inputStream = ImageLoader.class.getResourceAsStream("/images/myimage.png");
            Image image = ImageIO.read(inputStream);
            
            // For Toolkit image
            Image toolkitImage = Toolkit.getDefaultToolkit().getImage(
                ImageLoader.class.getResource("/images/myimage.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

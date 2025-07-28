import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageLoader {
    private static final String IMAGE_PATH = "/images/myimage.png";

    public static void main(String[] args) {
        try {
            // For ImageIcon
            new ImageIcon(ImageLoader.class.getResource(IMAGE_PATH));
            
            // For BufferedImage
            ImageIO.read(ImageLoader.class.getResourceAsStream(IMAGE_PATH));
            
            // For Toolkit image
            Toolkit.getDefaultToolkit().getImage(
                ImageLoader.class.getResource(IMAGE_PATH));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

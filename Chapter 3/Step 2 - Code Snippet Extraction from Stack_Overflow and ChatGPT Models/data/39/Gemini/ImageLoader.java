import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        try (InputStream inputStream = ImageLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                System.err.println("Could not find image at path: " + path);
                return null;
            }
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Assuming you have an 'images' folder in your project's resources directory
        BufferedImage image = loadImage("images/my_image.png");
        if (image != null) {
            System.out.println("Image loaded successfully! Width: " + image.getWidth() + ", Height: " + image.getHeight());
            // You can now use the 'image' object
        }
    }
}

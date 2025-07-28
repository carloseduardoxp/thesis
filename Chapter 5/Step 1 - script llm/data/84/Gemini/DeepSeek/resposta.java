import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;

public class AsciiArtConverter {

    // Define the ASCII character gradient (from light to dark)
    private static final String ASCII_GRADIENT = " .:-=+*#%@"; // You can customize this

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java AsciiArtConverter <image_path>");
            return;
        }

        String imagePath = args[0];
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            if (image == null) {
                System.err.println("Could not read image from: " + imagePath);
                return;
            }

            convertToAscii(image);

        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    private static void convertToAscii(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y += 2) { // Increment by 2 for height to account for character aspect ratio
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));

                // Calculate grayscale value (luminance)
                // A common formula for luminance: 0.2126*R + 0.7152*G + 0.0722*B
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int gray = (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);

                // Map grayscale value to ASCII character
                int index = (int) (gray / 255.0 * (ASCII_GRADIENT.length() - 1));
                System.out.print(ASCII_GRADIENT.charAt(index));
            }
            System.out.println(); // New line after each row
        }
    }
}
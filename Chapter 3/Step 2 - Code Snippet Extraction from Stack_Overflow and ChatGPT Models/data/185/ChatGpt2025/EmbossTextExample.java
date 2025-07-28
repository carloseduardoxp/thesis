import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EmbossTextExample {

    public static void main(String[] args) {
        try {
            // Load the original JPG image
            BufferedImage image = ImageIO.read(new File("input.jpg"));

            // Get Graphics2D context from image
            Graphics2D g2d = image.createGraphics();

            // Enable anti-aliasing for smooth text
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            // Text to emboss
            String text = "Embossed Text";

            // Font settings
            Font font = new Font("Arial", Font.BOLD, 60);
            g2d.setFont(font);

            // Position for the text
            int x = 50;
            int y = 100;

            // Emboss effect: draw shadow first (offset +1,+1) with dark color
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawString(text, x + 1, y + 1);

            // Then draw highlight (offset -1,-1) with white or light color
            g2d.setColor(Color.WHITE);
            g2d.drawString(text, x - 1, y - 1);

            // Finally draw the main text on top with the main color
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, x, y);

            g2d.dispose();

            // Save the modified image to a new file
            ImageIO.write(image, "jpg", new File("output_embossed.jpg"));

            System.out.println("Embossed text added successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EmbossedTextOnJPEG {

    public static void main(String[] args) throws IOException {
        // Load the JPEG image
        BufferedImage image = ImageIO.read(new File("input.jpg"));

        // Create a new graphics object for the image
        Graphics2D g2d = image.createGraphics();

        // Set rendering hints for smoother text
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Set the font and color for the text
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(Color.WHITE);

        // Calculate the position for the text
        int x = 100;
        int y = 100;

        // Set the color and position for the embossed text
        g2d.setColor(Color.BLACK);
        g2d.drawString("EMBOSSED", x + 2, y + 2);

        // Set the color and position for the regular text
        g2d.setColor(Color.WHITE);
        g2d.drawString("EMBOSSED", x, y);

        // Save the image to a file
        File output = new File("output.jpg");
        ImageIO.write(image, "jpg", output);
    }
}

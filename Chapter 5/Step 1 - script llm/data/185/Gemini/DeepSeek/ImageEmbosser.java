import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEmbosser {

    public static void main(String[] args) {
        String originalImagePath = "input.jpg"; // Your input JPG
        String outputPath = "output_embossed.jpg"; // Output JPG
        String textToEmboss = "EMBOSSED TEXT";
        int fontSize = 72;
        Color textColor = Color.GRAY; // A gray color works well for embossing

        try {
            // 1. Load the original JPG
            BufferedImage originalImage = ImageIO.read(new File(originalImagePath));
            if (originalImage == null) {
                System.err.println("Could not load original image: " + originalImagePath);
                return;
            }

            // 2. Create a temporary BufferedImage for the text
            BufferedImage textImage = new BufferedImage(
                    originalImage.getWidth(),
                    originalImage.getHeight(),
                    BufferedImage.TYPE_INT_ARGB); // Supports transparency

            // 3. Draw the text onto the textImage
            Graphics2D g2dText = textImage.createGraphics();
            g2dText.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2dText.setFont(new Font("Arial", Font.BOLD, fontSize));
            g2dText.setColor(textColor);

            // Calculate text position (e.g., center)
            int textWidth = g2dText.getFontMetrics().stringWidth(textToEmboss);
            int textHeight = g2dText.getFontMetrics().getHeight();
            int x = (originalImage.getWidth() - textWidth) / 2;
            int y = (originalImage.getHeight() - textHeight) / 2 + g2dText.getFontMetrics().getAscent();

            g2dText.drawString(textToEmboss, x, y);
            g2dText.dispose();

            // 4. Apply an embossing filter to the textImage
            // THIS IS WHERE YOU NEED TO IMPLEMENT OR USE AN EMBOSSING ALGORITHM
            BufferedImage embossedTextImage = applyEmbossFilter(textImage); // Call your embossing method

            // 5. Overlay the embossed text onto the original JPG
            Graphics2D g2dOriginal = originalImage.createGraphics();
            // Use AlphaComposite to blend the embossed text
            g2dOriginal.setComposite(AlphaComposite.SrcOver);
            g2dOriginal.drawImage(embossedTextImage, 0, 0, null);
            g2dOriginal.dispose();

            // 6. Save the result
            ImageIO.write(originalImage, "jpg", new File(outputPath));
            System.out.println("Embossed image saved to: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Placeholder for the embossing filter implementation.
     * This method would contain the pixel manipulation logic.
     */
    private static BufferedImage applyEmbossFilter(BufferedImage sourceImage) {
        // Implement the embossing convolution here.
        // This is a simplified example. A real implementation would iterate through
        // pixels, apply the kernel, and handle edge cases.
        // You might consider a separate utility class or method for image convolution.

        // Example: a very basic "emboss" that just shifts pixels (NOT a true emboss)
        // A true emboss uses convolution kernels and calculates new pixel values
        // based on neighbors.

        // This is a complex topic requiring pixel-level manipulation.
        // For a full embossing effect, you'd implement a convolution algorithm
        // using the 3x3 kernel mentioned above.

        // For simplicity, here's a highly conceptual idea of what you'd do:
        for (int y = 1; y < sourceImage.getHeight() - 1; y++) {
            for (int x = 1; x < sourceImage.getWidth() - 1; x++) {
                // Get pixel colors around (x,y)
                // Apply the emboss kernel calculation
                // Set the new pixel color in embossedImage
            }
        }

        // As a very, very basic illustration, returning the original for now.
        // YOU MUST REPLACE THIS WITH YOUR EMBOSSING LOGIC.
        return sourceImage;
    }
}
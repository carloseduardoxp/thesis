import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class TextEmbosser {
    
    public static void main(String[] args) {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File("input.jpg"));
            
            // Create a new image with the same dimensions
            BufferedImage embossedImage = new BufferedImage(
                originalImage.getWidth(), 
                originalImage.getHeight(), 
                BufferedImage.TYPE_INT_ARGB
            );
            
            // Get graphics context
            Graphics2D g2d = embossedImage.createGraphics();
            
            // Draw the original image as background
            g2d.drawImage(originalImage, 0, 0, null);
            
            // Set font and style for embossed text
            Font font = new Font("Arial", Font.BOLD, 48);
            g2d.setFont(font);
            
            // Text to emboss
            String text = "EMBOSSED";
            
            // Get font metrics to center text
            FontMetrics metrics = g2d.getFontMetrics();
            int x = (originalImage.getWidth() - metrics.stringWidth(text)) / 2;
            int y = (originalImage.getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            
            // Create emboss effect by drawing text with offset colors
            g2d.setColor(Color.GRAY);
            g2d.drawString(text, x+1, y+1); // Shadow
            g2d.setColor(Color.WHITE);
            g2d.drawString(text, x-1, y-1); // Highlight
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, x, y);     // Main text
            
            // Dispose graphics context
            g2d.dispose();
            
            // Save the embossed image
            ImageIO.write(embossedImage, "jpg", new File("output_embossed.jpg"));
            
            System.out.println("Text embossed successfully!");
            
        } catch (IOException ex) {
            System.err.println("Error processing image: " + ex.getMessage());
        }
    }
}

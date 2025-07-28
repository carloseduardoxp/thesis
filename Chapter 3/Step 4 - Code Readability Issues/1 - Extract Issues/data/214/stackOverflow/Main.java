import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        ImageIO.write(img, "BMP", new File("filename.bmp"));
    }
}

import java.awt.Color;
import java.util.Random;

public class Teste {

    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        Color color = new Color(r, g, b);
        String hex = String.format("#%06x", color.getRGB() & 0xffffff);
        System.out.println(hex);
    }
}

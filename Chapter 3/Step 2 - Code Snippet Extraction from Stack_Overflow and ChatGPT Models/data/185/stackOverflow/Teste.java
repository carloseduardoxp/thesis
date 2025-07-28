import java.awt.*;

public class Teste {

    public static void main(String[] args) throws java.lang.Exception {
        Graphics2D g = (Graphics2D) screen.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        Color c1 = new Color(0, 0, 0, 0);
        Color c2 = new Color(0, 0, 0, 100);
        GradientPaint gradient = new GradientPaint(10, 8, c1, 10, 40, c2, true);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, screen.width, screen.height);
        g.setColor(Color.BLACK);
        g.setPaint(gradient);
        g.fillRoundRect(100, 100, 200, 50, 25, 25);
        g.setPaint(Color.BLACK);
        g.drawRoundRect(100, 100, 200, 50, 25, 25);
        g.drawString("Hello World!", 118, 135);
    }
}

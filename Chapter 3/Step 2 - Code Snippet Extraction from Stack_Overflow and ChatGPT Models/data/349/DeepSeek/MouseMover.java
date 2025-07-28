import java.awt.Robot;
import java.awt.AWTException;

public class MouseMover {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            // Move mouse to specific coordinates (x, y)
            robot.mouseMove(500, 500);
            
            // You can also make smooth movements
            for (int i = 0; i < 100; i++) {
                robot.mouseMove(500 + i, 500 + i);
                robot.delay(10); // small delay between movements
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

import java.awt.Robot;
import java.awt.AWTException;

public class MoveMouse {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Move the mouse to coordinates (500, 300)
            robot.mouseMove(500, 300);

            System.out.println("Mouse moved to (500, 300)");
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

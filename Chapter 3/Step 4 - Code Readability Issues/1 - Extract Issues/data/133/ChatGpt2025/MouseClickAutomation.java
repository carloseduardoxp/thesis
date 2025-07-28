import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseClickAutomation {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Move the mouse to screen coordinates (500, 300)
            robot.mouseMove(500, 300);

            // Wait 1 second (1000 milliseconds)
            robot.delay(1000);

            // Press left mouse button
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

            // Release left mouse button
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            System.out.println("Mouse click performed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

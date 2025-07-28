import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseClickAutomation {
    public static void main(String[] args) throws Exception {
        // Create a Robot instance
        Robot robot = new Robot();

        // Simulate a left mouse click
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // Simulate a right mouse click
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

        // Move the mouse to (100, 100)
        robot.mouseMove(100, 100);

        // Simulate a left mouse click at the current mouse location
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }
}

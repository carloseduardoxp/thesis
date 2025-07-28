import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.MouseInfo;
import java.awt.Point;

public class MouseClickAutomator {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Optional: Get current mouse position (useful for debugging or relative movements)
            Point currentMousePosition = MouseInfo.getPointerInfo().getLocation();
            System.out.println("Current mouse position: X=" + currentMousePosition.x + ", Y=" + currentMousePosition.y);

            // Give yourself a few seconds to switch to the window you want to click on
            System.out.println("Moving mouse and clicking in 5 seconds...");
            robot.delay(5000); // 5-second delay

            // 1. Move the mouse to a specific location (e.g., 500, 300)
            int targetX = 500;
            int targetY = 300;
            robot.mouseMove(targetX, targetY);
            System.out.println("Mouse moved to: X=" + targetX + ", Y=" + targetY);

            // Add a small delay after moving the mouse
            robot.delay(500);

            // 2. Press the left mouse button
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("Left mouse button pressed.");

            // Add a small delay for the click to register
            robot.delay(50);

            // 3. Release the left mouse button
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("Left mouse button released. Click complete.");

        } catch (AWTException e) {
            e.printStackTrace();
            System.err.println("Error initializing Robot: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("Invalid screen coordinates provided: " + e.getMessage());
        }
    }
}

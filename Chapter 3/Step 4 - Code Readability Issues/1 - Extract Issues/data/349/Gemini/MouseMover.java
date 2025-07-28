import java.awt.AWTException;
import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.Point;

public class MouseMover {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // --- Moving the mouse to a specific absolute position ---
            int newX = 500; // X-coordinate
            int newY = 300; // Y-coordinate
            System.out.println("Moving mouse to (" + newX + ", " + newY + ")");
            robot.mouseMove(newX, newY);
            Thread.sleep(2000); // Wait for 2 seconds to see the movement

            // --- Moving the mouse relative to its current position (example) ---
            Point currentLocation = MouseInfo.getPointerInfo().getLocation();
            int currentX = currentLocation.x;
            int currentY = currentLocation.y;

            int moveRightBy = 100;
            int moveDownBy = 50;

            int targetX = currentX + moveRightBy;
            int targetY = currentY + moveDownBy;

            System.out.println("Current mouse position: (" + currentX + ", " + currentY + ")");
            System.out.println("Moving mouse relatively to (" + targetX + ", " + targetY + ")");
            robot.mouseMove(targetX, targetY);
            Thread.sleep(2000);

            // --- Moving the mouse in a simple pattern (e.g., a square) ---
            System.out.println("Moving mouse in a square pattern...");
            int startX = 200;
            int startY = 200;
            int size = 150;

            // Move to start
            robot.mouseMove(startX, startY);
            Thread.sleep(500);

            // Right
            robot.mouseMove(startX + size, startY);
            Thread.sleep(500);

            // Down
            robot.mouseMove(startX + size, startY + size);
            Thread.sleep(500);

            // Left
            robot.mouseMove(startX, startY + size);
            Thread.sleep(500);

            // Up (back to start)
            robot.mouseMove(startX, startY);
            System.out.println("Mouse movement complete.");


        } catch (AWTException e) {
            System.err.println("AWTException: " + e.getMessage());
            System.err.println("This usually means your system does not allow Robot control (e.g., due to security settings).");
        } catch (InterruptedException e) {
            System.err.println("InterruptedException: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
}

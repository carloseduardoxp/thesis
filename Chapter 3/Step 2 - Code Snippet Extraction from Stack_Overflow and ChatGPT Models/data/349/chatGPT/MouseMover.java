import java.awt.*;

public class MouseMover {
    public static void main(String[] args) throws Exception {
        // Create a Robot object
        Robot robot = new Robot();

        // Get the current position of the mouse cursor
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        // Move the mouse cursor to a new location
        robot.mouseMove(x + 50, y + 50);
    }
}

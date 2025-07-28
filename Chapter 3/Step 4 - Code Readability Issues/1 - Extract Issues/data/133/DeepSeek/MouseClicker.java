import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseClicker {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        
        // Move mouse to coordinates (x, y)
        robot.mouseMove(500, 300);
        
        // Left click
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
        // Right click
        // robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        // robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        
        // Double click
        // robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // robot.delay(50);
        // robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}

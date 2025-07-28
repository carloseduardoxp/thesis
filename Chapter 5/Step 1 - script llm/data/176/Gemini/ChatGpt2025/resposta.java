import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class MonitorLister {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screenDevices = ge.getScreenDevices();

        System.out.println("Found " + screenDevices.length + " screen(s):");

        for (int i = 0; i < screenDevices.length; i++) {
            GraphicsDevice gd = screenDevices[i];
            System.out.println("\n--- Monitor " + i + " ---");
            System.out.println("ID String: " + gd.getIDstring());
            System.out.println("Default Configuration Bounds: " + gd.getDefaultConfiguration().getBounds());

            // You can also get more detailed information about the current display mode
            java.awt.DisplayMode dm = gd.getDisplayMode();
            System.out.println("Current Display Mode: " +
                               dm.getWidth() + "x" + dm.getHeight() +
                               " @" + dm.getRefreshRate() + "Hz " +
                               dm.getBitDepth() + "-bit");
        }
    }
}

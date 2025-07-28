import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class MultiMonitorExample {

  public static void main(String[] args) {

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();

    // Iterate over all connected displays
    for (int i = 0; i < gs.length; i++) {
      GraphicsDevice gd = gs[i];
      System.out.println("Display " + i + ": " + gd);

      // Set up your GUI for each display
      // For example:
      // JFrame frame = new JFrame(gd.getDefaultConfiguration());
      // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frame.add(new JLabel("Display " + i));
      // frame.pack();
      // frame.setLocationRelativeTo(null);
      // frame.setVisible(true);
    }
  }
}

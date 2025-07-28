import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class SwingPopupMenuExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Popup Menu Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null); // Simple layout for demonstration

        JButton button = new JButton("Click for Popup");
        button.setBounds(100, 100, 150, 30);
        frame.add(button);

        // Create a JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Option 1");
        JMenuItem item2 = new JMenuItem("Option 2");
        JMenuItem item3 = new JMenuItem("Exit");

        item1.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Option 1 selected!"));
        item2.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Option 2 selected!"));
        item3.addActionListener(e -> System.exit(0));

        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.addSeparator(); // Add a separator line
        popupMenu.add(item3);

        // Attach the popup menu to the button
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Show the popup at the button's location
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        frame.setVisible(true);
    }
}

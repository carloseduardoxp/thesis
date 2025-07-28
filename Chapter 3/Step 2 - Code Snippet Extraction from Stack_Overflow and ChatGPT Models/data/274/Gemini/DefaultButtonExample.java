import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultButtonExample extends JFrame {

    public DefaultButtonExample() {
        setTitle("Default Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        add(panel);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DefaultButtonExample.this, "OK Button Pressed!");
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DefaultButtonExample.this, "Cancel Button Pressed!");
            }
        });

        panel.add(okButton);
        panel.add(cancelButton);

        // *** THIS IS THE KEY LINE ***
        getRootPane().setDefaultButton(okButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DefaultButtonExample());
    }
}

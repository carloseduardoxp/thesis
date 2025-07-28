import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Concrete Product 1
class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World! (HTML)'");
    }
}
// Concrete Product 2


public class WindowsButton implements Button {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button;

    @Override
    public void render() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        button = new JButton("Click me!");
        button.addActionListener(e -> onClick());

        panel.add(label);
        panel.add(button);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World! (Windows)'");
    }
}

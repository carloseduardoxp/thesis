import javax.swing.*;

public class ButtonTextChanger extends JFrame {

    private JButton myButton;
    private int clickCount = 0;

    public ButtonTextChanger() {
        setTitle("Button Text Changer");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create the button
        myButton = new JButton("Click Me!");

        // Add an ActionListener to the button
        myButton.addActionListener(e -> {
            clickCount++;
            if (clickCount % 2 == 1) {
                myButton.setText("You Clicked Me!");
            } else {
                myButton.setText("Click Me Again!");
            }
        });

        // Add the button to the frame
        add(myButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(ButtonTextChanger::new);
    }
}

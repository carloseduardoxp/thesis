
import java.awt.event.*;
import javax.swing.*;

public class Actions extends JFrame implements ActionListener {

    JPanel pnl = new JPanel();
    ImageIcon ic1 = new ImageIcon("/home/mudit/Downloads/duke.png");
    JButton btn1 = new JButton("Click", ic1);
    JTextArea ta = new JTextArea(5, 37);

    public static void main(String[] args) {
        Actions gui = new Actions();
    }

    public Actions() {
        super("Swing Window");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        btn1.setHorizontalTextPosition(JButton.CENTER);
        btn1.setVerticalTextPosition(JButton.BOTTOM);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        pnl.add(btn1);
        pnl.add(ta);
        btn1.setEnabled(true);
        ta.setText("Button is enabled");
        btn1.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn1) {
            if (event.getSource() == btn1) {
                if (ta.getText().equals("Button is enabled")) {
                    ta.setText("Button is Clicked");
                } else {
                    ta.setText("Button is enabled");
                }
            }

        }
    }
}

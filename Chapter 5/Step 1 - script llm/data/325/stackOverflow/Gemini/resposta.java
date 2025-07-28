import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Actions extends JFrame implements ActionListener {

    private static final String BUTTON_ENABLED_TEXT = "Button is enabled";
    private static final String BUTTON_CLICKED_TEXT = "Button is Clicked";

    JPanel pnl = new JPanel();
    ImageIcon ic1 = new ImageIcon("/home/mudit/Downloads/duke.png");
    JButton btn1 = new JButton("Click", ic1);
    JTextArea ta = new JTextArea(5, 37);

    public static void main(String[] args) {
        new Actions();
    }

    public Actions() {
        super("Swing Window");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        pnl.add(btn1);
        pnl.add(ta);
        btn1.setEnabled(true);
        ta.setText(BUTTON_ENABLED_TEXT);
        btn1.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn1) {
            if (ta.getText().equals(BUTTON_ENABLED_TEXT)) {
                ta.setText(BUTTON_CLICKED_TEXT);
            } else {
                ta.setText(BUTTON_ENABLED_TEXT);
            }
        }
    }
}


import javax.swing.JButton;
import javax.swing.JFrame;

public class Teste {

    public static void main(String[] args) {        
        JButton btn = new JButton();
        JFrame frame = new JFrame();
       
        frame.getContentPane().add(btn);
        frame.getRootPane().setDefaultButton(btn);
    }
}
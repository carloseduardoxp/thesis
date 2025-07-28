import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Teste {

    public static void main(String[] args) {
        if (!ar.get(16).equals("empty")) {
            String photo = (String) ar.get(16);

            System.out.println(photo);

            ImageIcon image = new ImageIcon("C:/images/image.png");
            ImageIcon img = new ImageIcon(image.getScaledInstance(view.jLabel5.getWidth(), view.jLabel5.getHeight(), 0));

            view.jLabel5.setPreferredSize(new Dimension(100, 100));
            view.jLabel5.setIcon(img);
        }
    }
}

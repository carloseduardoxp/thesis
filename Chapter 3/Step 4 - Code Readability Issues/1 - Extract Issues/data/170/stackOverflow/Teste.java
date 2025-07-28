
import java.io.File;
import java.io.FileInputStream;

public class Teste {

    public static void main(String[] args) {

        try {
            File file = new File("a.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String str = new String(data, "UTF-8");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

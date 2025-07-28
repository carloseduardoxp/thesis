import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Teste {

    public static void main(String[] args) {
        try {
            File file = new File("a.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            new String(data, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

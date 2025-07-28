import java.io.BufferedReader;
import java.io.FileReader;

public class Teste {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader(myFile));
        String s;
        while ((s = r.readLine()) != null) {
            // do something with s
        }
        r.close();
    }
}
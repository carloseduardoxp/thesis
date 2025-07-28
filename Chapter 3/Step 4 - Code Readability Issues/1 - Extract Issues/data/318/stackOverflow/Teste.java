
import java.io.BufferedReader;
import java.io.FileReader;

public class Teste {

    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new FileReader(myFile));
        int c;
        while (-1 != (c = r.read())) {
            String s = r.readLine();
            // do something with s
        }
        r.close();
    }
}

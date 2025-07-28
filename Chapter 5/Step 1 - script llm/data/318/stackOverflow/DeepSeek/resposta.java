import java.io.BufferedReader;
import java.io.FileReader;

public class Teste {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader(myFile));
        while (r.readLine() != null) {
            // do something with each line
        }
        r.close();
    }
}

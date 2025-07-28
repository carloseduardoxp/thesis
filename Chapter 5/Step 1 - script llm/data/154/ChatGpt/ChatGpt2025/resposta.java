import java.io.File;
import java.io.FileNotFoundException;

public class Example {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            // ...
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
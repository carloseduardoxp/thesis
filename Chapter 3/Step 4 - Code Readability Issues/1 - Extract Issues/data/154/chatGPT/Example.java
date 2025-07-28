import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            // ...
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

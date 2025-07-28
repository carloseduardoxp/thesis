
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Teste {

    public static void main(String[] args) {
        try {
            // some i/o function
            reader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            // catch the error , you can log these
            e.printStackTrace();

        } catch (IOException e) {
            // catch the error , you can log these
            e.printStackTrace();
        }
    }
}

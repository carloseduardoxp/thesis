import java.io.FileWriter;
import java.io.IOException;

public class CreateTextFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, this is a text file created in Java!");
            writer.close();
            System.out.println("File created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

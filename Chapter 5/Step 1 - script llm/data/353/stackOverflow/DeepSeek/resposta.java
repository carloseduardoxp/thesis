import java.io.*;

public class Program {
    public static void main(String[] args) {
        String text = "Hello world";
        try (BufferedWriter output = new BufferedWriter(new FileWriter("example.txt"))) {
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

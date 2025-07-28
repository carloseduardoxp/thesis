import java.io.*;

public class Program {
    public static void main(String[] args) {
        String text = "Hello world";
        File file = new File("example.txt");
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

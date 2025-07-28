import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Teste {
    public static void main(String[] args) throws IOException {
        // Create a FileWriter or BufferedWriter object
        BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
        
        // Write text to the file
        writer.write("Hello World!");
        writer.newLine();
        writer.write("This is a text file.");
        
        // Remember to flush and close the writer
        writer.flush();
        writer.close();
    }
}

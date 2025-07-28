import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadCSV {
    public static void main(String[] args) {
        String fileURL = "https://example.com/data.csv";  // replace with your CSV URL
        String savePath = "data.csv";

        try (InputStream in = new URL(fileURL).openStream()) {
            Files.copy(in, Paths.get(savePath));
            System.out.println("Download complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

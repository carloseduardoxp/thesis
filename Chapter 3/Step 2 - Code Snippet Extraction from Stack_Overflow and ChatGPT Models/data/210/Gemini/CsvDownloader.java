import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class CsvDownloader {

    public static void downloadCsvFromUrl(String fileURL, String savePath) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("CSV file downloaded successfully to: " + savePath);

        } catch (IOException e) {
            System.err.println("Error downloading CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Alternative using NIO for potentially better performance with large files
    public static void downloadCsvFromUrlNio(String fileURL, String savePath) {
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(savePath);
             // FileChannel can be obtained from FileOutputStream
             java.nio.channels.FileChannel fileChannel = fileOutputStream.getChannel()) {

            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            System.out.println("CSV file downloaded (NIO) successfully to: " + savePath);

        } catch (IOException e) {
            System.err.println("Error downloading CSV file (NIO): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String csvUrl = "https://raw.githubusercontent.com/datasets/gdp/main/data/gdp.csv"; // Example public CSV URL
        String saveDirectory = "./downloads/"; // Create a 'downloads' folder in your project or specify an absolute path
        String fileName = "gdp_data.csv";
        String savePath = saveDirectory + fileName;

        // Ensure the directory exists
        new java.io.File(saveDirectory).mkdirs();

        System.out.println("Downloading using Stream...");
        downloadCsvFromUrl(csvUrl, savePath);

        // You can also try the NIO version
        // System.out.println("\nDownloading using NIO...");
        // downloadCsvFromUrlNio(csvUrl, savePath);
    }
}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyNIO {

    public static void main(String[] args) {
        Path sourcePath = Paths.get("source.txt"); // Replace with your source file
        Path destinationPath = Paths.get("destination.txt"); // Replace with your destination file

        try {
            // Create dummy files for demonstration
            java.nio.file.Files.write(sourcePath, "This is some test content for the source file.\n"
                    .getBytes());
            java.nio.file.Files.write(sourcePath, "More content to make it a bit longer.\n"
                    .getBytes(), java.nio.file.StandardOpenOption.APPEND);

            copyFile(sourcePath, destinationPath);
            System.out.println("File copied successfully from " + sourcePath + " to " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void copyFile(Path source, Path destination) throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(source.toFile()).getChannel();
             FileChannel destinationChannel = new FileOutputStream(destination.toFile()).getChannel()) {

            long totalBytesTransferred = 0;
            long fileSize = sourceChannel.size(); // Get the size of the source file

            while (totalBytesTransferred < fileSize) {
                long bytesTransferred = destinationChannel.transferFrom(
                        sourceChannel,
                        totalBytesTransferred,
                        fileSize - totalBytesTransferred
                );

                if (bytesTransferred == 0) {
                    // This might happen if the source channel is empty or temporarily has no data
                    // For file channels, it's unlikely to happen unless the file is truly empty
                    // or there's an issue. For network channels, it indicates no data is ready.
                    // In some cases, you might want to add a small delay here to prevent
                    // busy-waiting, especially with network channels.
                    break; // Or continue after a small delay if it's a network channel
                }
                totalBytesTransferred += bytesTransferred;
                System.out.println("Transferred: " + bytesTransferred + " bytes. Total: " + totalBytesTransferred);
            }
        }
    }
}

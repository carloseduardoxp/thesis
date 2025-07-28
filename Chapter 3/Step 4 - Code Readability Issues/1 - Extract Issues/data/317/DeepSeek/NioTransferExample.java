import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioTransferExample {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        try (FileChannel sourceChannel = FileChannel.open(Paths.get(sourceFile), StandardOpenOption.READ);
             FileChannel destChannel = FileChannel.open(Paths.get(destFile), 
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            
            long position = 0;
            long count = sourceChannel.size();
            
            // Transfer loop using transferFrom
            while (position < count) {
                position += destChannel.transferFrom(sourceChannel, position, count - position);
            }
            
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

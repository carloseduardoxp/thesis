import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileTransferExample {
    public static void main(String[] args) throws Exception {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        try (FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();
             FileChannel destChannel = new FileOutputStream(destFile).getChannel()) {
             
            long position = 0;
            long count = sourceChannel.size();
            
            while (position < count) {
                position += destChannel.transferFrom(sourceChannel, position, count - position);
            }
        }
    }
}

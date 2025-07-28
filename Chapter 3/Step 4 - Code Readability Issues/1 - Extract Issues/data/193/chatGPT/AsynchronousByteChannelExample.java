import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousByteChannelExample {

    public static void main(String[] args) {
        try {
            // Open a file for reading
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                    Paths.get("test.txt"), StandardOpenOption.READ);

            // Allocate a buffer to hold the read data
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Initiate an asynchronous read operation
            Future<Integer> result = fileChannel.read(buffer, 0);

            // Wait for the read operation to complete
            while (!result.isDone()) {
                System.out.println("Waiting for read operation to complete...");
                Thread.sleep(1000);
            }

            // Get the number of bytes read and print the data
            int bytesRead = result.get();
            System.out.println("Bytes read: " + bytesRead);
            buffer.flip();
            System.out.println("Data read: " + new String(buffer.array(), 0, bytesRead));

            // Close the channel
            fileChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

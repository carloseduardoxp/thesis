import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncFileReadWrite {

    public static void main(String[] args) throws IOException, InterruptedException {
        // --- Reading with Future ---
        readWithFuture();

        System.out.println("\n--- Writing with CompletionHandler ---");
        writeWithCompletionHandler();

        // Keep the main thread alive for a bit to allow async operations to complete
        Thread.sleep(2000);
        System.out.println("Main thread continuing...");
    }

    private static void readWithFuture() throws IOException {
        Path filePath = Paths.get("sample.txt");
        // Ensure the file exists for reading, or create it if not
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> readResult = fileChannel.read(buffer, 0); // Start reading from position 0

            System.out.println("Read operation started...");

            try {
                Integer bytesRead = readResult.get(); // This will block until read completes
                System.out.println("Bytes read (Future): " + bytesRead);
                buffer.flip(); // Prepare buffer for reading
                byte[] data = new byte[bytesRead];
                buffer.get(data);
                System.out.println("Content: " + new String(data));
            } catch (Exception e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
    }

    private static void writeWithCompletionHandler() throws IOException {
        Path filePath = Paths.get("output.txt");
        String content = "Hello from AsynchronousByteChannel!";
        ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());

        // Ensure the file exists for writing, or create/truncate it
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(filePath,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

            System.out.println("Write operation started...");

            fileChannel.write(buffer, 0, null, new CompletionHandler<Integer, Void>() {
                @Override
                public void completed(Integer bytesWritten, Void attachment) {
                    System.out.println("Bytes written (CompletionHandler): " + bytesWritten);
                    System.out.println("File 'output.txt' created/updated successfully.");
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    System.err.println("Error writing file: " + exc.getMessage());
                }
            });
            // The main thread continues immediately, without waiting for the write to finish
            System.out.println("Main thread continues after initiating write...");
        }
    }
}

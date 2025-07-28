
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.concurrent.Future;

public class DeepSeek {

    public static void main(String[] args) {

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("file.txt"));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> readResult = channel.read(buffer, 0);

// Do other work while reading...
        readResult.get(); // Wait for completion if needed
        buffer.flip();
// Process the read data

    }

}

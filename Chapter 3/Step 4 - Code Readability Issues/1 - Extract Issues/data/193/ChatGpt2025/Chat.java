
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;


public class Chat {

    public static void main(String[] args) {

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(
                Paths.get("arquivo.txt"),
                StandardOpenOption.READ
        );

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                System.out.println("Lido: " + new String(attachment.array(), 0, result));
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.err.println("Erro ao ler: " + exc.getMessage());
            }
        });

    }

}


import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.concurrent.*;

public class AsynchronousCompletionHandler<T> implements CompletionHandler<T, CompletableFuture<T>> {

    public void completed(T result, CompletableFuture<T> attachment) {
        attachment.complete(result);
    }

    public void failed(Throwable ex, CompletableFuture<T> attachment) {
        attachment.completeExceptionally(ex);
    }

    private static final ConcurrentHashMap<Class<?>, AsynchronousCompletionHandler<?>> cache = new ConcurrentHashMap<>();

    static <T> AsynchronousCompletionHandler<T> getInstance(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        AsynchronousCompletionHandler<T> handler = (AsynchronousCompletionHandler<T>) cache.computeIfAbsent(clazz, c -> new AsynchronousCompletionHandler<T>());
        return handler;
    }

    //
    // AsynchronousByteChannel
    public static CompletableFuture<Integer> readAsync(AsynchronousByteChannel channel, ByteBuffer dst) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.read(dst, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> writeAsync(AsynchronousByteChannel channel, ByteBuffer src) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.write(src, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    //
    // AsynchronousFileChannel
    public static CompletableFuture<FileLock> lockAsync(AsynchronousFileChannel channel) {
        CompletableFuture<FileLock> completableFuture = new CompletableFuture<>();
        channel.lock(completableFuture, getInstance(FileLock.class));
        return completableFuture;
    }

    public static CompletableFuture<FileLock> lockAsync(AsynchronousFileChannel channel, long position, long size, boolean shared) {
        CompletableFuture<FileLock> completableFuture = new CompletableFuture<>();
        channel.lock(position, size, shared, completableFuture, getInstance(FileLock.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> readAsync(AsynchronousFileChannel channel, ByteBuffer dst, long position) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.read(dst, position, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> writeAsync(AsynchronousFileChannel channel, ByteBuffer src, long position) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.write(src, position, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    //
    // AsynchronousServerSocketChannel
    public static CompletableFuture<AsynchronousSocketChannel> acceptAsync(AsynchronousServerSocketChannel channel) {
        CompletableFuture<AsynchronousSocketChannel> completableFuture = new CompletableFuture<>();
        channel.accept(completableFuture, getInstance(AsynchronousSocketChannel.class));
        return completableFuture;
    }

    //
    // AsynchronousSocketChannel
    public static CompletableFuture<Void> connectAsync(AsynchronousSocketChannel channel, SocketAddress remote) {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        channel.connect(remote, completableFuture, getInstance(Void.class));
        return completableFuture;
    }

    public static CompletableFuture<Long> readAsync(AsynchronousSocketChannel channel, ByteBuffer[] dsts, int offset, int length, long timeout, TimeUnit unit) {
        CompletableFuture<Long> completableFuture = new CompletableFuture<>();
        channel.read(dsts, offset, length, timeout, unit, completableFuture, getInstance(Long.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> readAsync(AsynchronousSocketChannel channel, ByteBuffer dst) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.read(dst, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> readAsync(AsynchronousSocketChannel channel, ByteBuffer dst, long timeout, TimeUnit unit) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.read(dst, timeout, unit, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    public static CompletableFuture<Long> writeAsync(AsynchronousSocketChannel channel, ByteBuffer[] srcs, int offset, int length, long timeout, TimeUnit unit) {
        CompletableFuture<Long> completableFuture = new CompletableFuture<>();
        channel.write(srcs, offset, length, timeout, unit, completableFuture, getInstance(Long.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> writeAsync(AsynchronousSocketChannel channel, ByteBuffer src) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.write(src, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    public static CompletableFuture<Integer> writeAsync(AsynchronousSocketChannel channel, ByteBuffer src, long timeout, TimeUnit unit) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        channel.write(src, timeout, unit, completableFuture, getInstance(Integer.class));
        return completableFuture;
    }

    public static void main(String[] args) {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(5000));
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        acceptAsync(serverChannel)
                .thenCompose(clientChannel -> readAsync(clientChannel, buffer))
                .thenAccept(readBytes -> System.out.format("read %d bytes from client%n", readBytes));
    }
}

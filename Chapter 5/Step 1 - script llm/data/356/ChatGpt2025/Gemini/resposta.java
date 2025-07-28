import java.util.concurrent.CompletableFuture;

public class AsyncSendExample {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(AsyncSendExample::sendData);

        // You can do other tasks here...

        // Optionally wait for completion
        future.join();
    }

    public static void sendData() {
        System.out.println("Sending data asynchronously...");
        // Simulate sending data (e.g., HTTP request, socket send)
        try {
            Thread.sleep(2000); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data sent!");
    }
}


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncSender {
    public static void main(String[] args) {
        // Start async operation
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate long-running task
            try {
                Thread.sleep(1000);
                System.out.println("Data sent asynchronously");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Do other work while async operation runs
        
        // Wait for completion if needed
        try {
            future.get(); // blocks until complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

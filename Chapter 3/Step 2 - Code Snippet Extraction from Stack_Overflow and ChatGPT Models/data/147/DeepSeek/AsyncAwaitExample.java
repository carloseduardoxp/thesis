import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncAwaitExample {
    
    public static void main(String[] args) {
        // Start async operation
        CompletableFuture<String> future = asyncOperation();
        
        // Do other work while async operation runs
        
        try {
            // "await" - blocks until result is available
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    public static CompletableFuture<String> asyncOperation() {
        // Simulate an async operation
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Async operation completed";
        });
    }
}

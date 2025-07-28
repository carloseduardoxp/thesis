import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncExample {

    // Simulates an asynchronous operation (e.g., a network call, database query)
    public static CompletableFuture<String> fetchUserData(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Fetching user data for " + userId + " on thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "User: " + userId + ", Name: Alice";
        });
    }

    public static CompletableFuture<String> processUserData(String userData) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Processing user data: " + userData + " on thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return userData.toUpperCase();
        });
    }

    public static void main(String[] args) {
        System.out.println("Main thread started: " + Thread.currentThread().getName());

        // This simulates an "async function" that returns a CompletableFuture
        CompletableFuture<String> finalResultFuture = fetchUserData("123")
            // This is like 'awaiting' the first operation and then chaining another
            .thenCompose(userData -> {
                System.out.println("Finished fetching, now processing...");
                return processUserData(userData);
            })
            // This is like 'awaiting' the second operation and then handling the final result
            .thenApply(processedData -> {
                System.out.println("Finished processing, final transformation...");
                return "Final Result: " + processedData;
            })
            // Error handling (optional)
            .exceptionally(ex -> {
                System.err.println("An error occurred: " + ex.getMessage());
                return "Error fetching data";
            });

        // "Await" the final result (blocking the main thread here for demonstration)
        try {
            String result = finalResultFuture.join(); // or .get()
            System.out.println("Received final result: " + result);
        } catch (Exception e) {
            System.err.println("Failed to get final result: " + e.getMessage());
        }

        System.out.println("Main thread finished.");
    }
}

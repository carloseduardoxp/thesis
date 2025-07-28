import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample {

    // Simulate an async method returning a CompletableFuture
    public static CompletableFuture<String> fetchDataAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data fetched!";
        });
    }

    public static void main(String[] args) {
        System.out.println("Start fetching...");

        CompletableFuture<String> future = fetchDataAsync();

        // This is similar to 'await' because get() blocks until the future is complete
        try {
            String result = future.get();  // wait for the async task to complete
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}

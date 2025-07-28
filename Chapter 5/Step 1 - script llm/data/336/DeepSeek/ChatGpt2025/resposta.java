import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class DeepSeek {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4); // Create thread pool
        List<Future<?>> futures = new ArrayList<>();

        for (Object item : collection)
            futures.add(executor.submit(() -> 
                // Process each item here
                processItem(item)
            ));

        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            try {
                future.get(); // Get will block until task completes
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown(); // Always shutdown the executor

    }

}

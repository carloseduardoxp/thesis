
import java.util.ArrayList;
import java.util.List;


public class DeepSeek {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4); // Create thread pool
        List<Future<?>> futures = new ArrayList<>();

        for (Object item : collection) {
            futures.add(executor.submit(() -> {
                // Process each item here
                processItem(item);
            }));
        }

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

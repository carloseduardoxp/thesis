import java.util.concurrent.*;

public class ConcurrentJobExample {

    public static void main(String[] args) {
        // 1. Create a thread pool
        // This will create a pool of 3 threads.
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2. Define your tasks (using Runnable or Callable)
        Runnable task1 = () -> {
            try {
                System.out.println("Task 1: Starting...");
                Thread.sleep(2000); // Simulate work
                System.out.println("Task 1: Finished.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task 1: Interrupted.");
            }
        };

        Callable<String> task2 = () -> {
            try {
                System.out.println("Task 2: Starting...");
                Thread.sleep(3000); // Simulate work
                System.out.println("Task 2: Finished.");
                return "Result from Task 2";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task 2: Interrupted.");
                return "Task 2: Interrupted";
            }
        };

        Runnable task3 = () -> {
            try {
                System.out.println("Task 3: Starting...");
                Thread.sleep(1500); // Simulate work
                System.out.println("Task 3: Finished.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task 3: Interrupted.");
            }
        };

        // 3. Submit tasks for execution
        executorService.execute(task1); // Fire and forget
        Future<String> future2 = executorService.submit(task2); // Get a Future for the result
        executorService.execute(task3);

        // 4. Retrieve results if needed (for Callable tasks)
        try {
            String result2 = future2.get(); // This will block until Task 2 completes
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 5. Submit more tasks to demonstrate queueing
        Runnable task4 = () -> {
            System.out.println("Task 4: Starting (after others are in queue/running)...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task 4: Finished.");
        };
        executorService.execute(task4);

        // 6. Shut down the executor service
        // It's crucial to shut down the ExecutorService to release resources.
        executorService.shutdown();

        // Optional: Wait for all tasks to complete before truly exiting
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Force shutdown if not all tasks completed in time
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks submitted and ExecutorService shut down.");
    }
}

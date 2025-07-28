import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

// Represents a single data record from the interface
class InterfaceRecord {
    private int id;
    private String data;

    public InterfaceRecord(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Record{" + "id=" + id + ", data='" + data + '\'' + '}';
    }
}

// Simulates fetching data from an interface
class DataProducer implements Runnable {
    private final BlockingQueue<List<InterfaceRecord>> queue;
    private final int numBatches;
    private final int batchSize;

    public DataProducer(BlockingQueue<List<InterfaceRecord>> queue, int numBatches, int batchSize) {
        this.queue = queue;
        this.numBatches = numBatches;
        this.batchSize = batchSize;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numBatches; i++) {
                List<InterfaceRecord> batch = new ArrayList<>();
                for (int j = 0; j < batchSize; j++) {
                    batch.add(new InterfaceRecord(i * batchSize + j, "Data-" + (i * batchSize + j)));
                }
                System.out.println(Thread.currentThread().getName() + " produced batch " + i + " of size " + batch.size());
                queue.put(batch); // Blocks if queue is full
                Thread.sleep(50); // Simulate data fetching delay
            }
            // Signal completion to consumers (e.g., by putting a "poison pill" or shutting down executor)
            queue.put(new ArrayList<>()); // Empty list as a poison pill (simple example)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted: " + e.getMessage());
        }
    }
}

// Simulates processing and updating data in a batch
class DataConsumer implements Runnable {
    private final BlockingQueue<List<InterfaceRecord>> queue;
    private final String consumerName;

    public DataConsumer(BlockingQueue<List<InterfaceRecord>> queue, String consumerName) {
        this.queue = queue;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                List<InterfaceRecord> batch = queue.take(); // Blocks if queue is empty
                if (batch.isEmpty()) { // Check for poison pill
                    queue.put(batch); // Re-put for other consumers
                    break;
                }
                System.out.println(consumerName + " consumed batch of size: " + batch.size());
                // Simulate batch processing and database update
                for (InterfaceRecord interfaceRecord : batch) {
                    // In a real application, this would involve database insert/update operations
                    // using JDBC batch updates or an ORM like Hibernate batching.
                    // For demonstration, we just print.
                }
                Thread.sleep(100); // Simulate processing time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(consumerName + " interrupted: " + e.getMessage());
        }
    }
}

public class BatchSynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        int queueCapacity = 5;
        int numBatches = 10;
        int batchSize = 20;
        int numConsumers = 3;

        BlockingQueue<List<InterfaceRecord>> dataQueue = new ArrayBlockingQueue<>(queueCapacity);
        ExecutorService executorService = Executors.newFixedThreadPool(numConsumers + 1); // +1 for the producer

        // Start the producer
        executorService.submit(new DataProducer(dataQueue, numBatches, batchSize));

        // Start consumers
        for (int i = 0; i < numConsumers; i++) {
            executorService.submit(new DataConsumer(dataQueue, "Consumer-" + (i + 1)));
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.err.println("Executor did not terminate in the allotted time.");
            executorService.shutdownNow();
        }
        System.out.println("Batch synchronization finished.");
    }
}

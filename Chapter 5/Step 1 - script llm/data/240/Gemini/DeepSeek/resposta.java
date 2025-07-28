import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
                queue.put(batch);
                Thread.sleep(50);
            }
            queue.put(new ArrayList<>());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted: " + e.getMessage());
        }
    }
}

class DataConsumer implements Runnable {
    private final BlockingQueue<List<InterfaceRecord>> queue;
    private final String consumerId;

    public DataConsumer(BlockingQueue<List<InterfaceRecord>> queue, String consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                List<InterfaceRecord> batch = queue.take();
                if (batch.isEmpty()) {
                    queue.put(batch);
                    break;
                }
                System.out.println(consumerId + " consumed batch of size: " + batch.size());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(consumerId + " interrupted: " + e.getMessage());
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
        ExecutorService executorService = Executors.newFixedThreadPool(numConsumers + 1);

        executorService.submit(new DataProducer(dataQueue, numBatches, batchSize));

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

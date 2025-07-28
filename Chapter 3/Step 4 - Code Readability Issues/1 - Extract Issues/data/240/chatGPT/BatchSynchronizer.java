import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchSynchronizer {
    private final DataService dataService;
    private final int batchSize;
    private final ExecutorService executorService;

    public BatchSynchronizer(DataService dataService, int batchSize) {
        this.dataService = dataService;
        this.batchSize = batchSize;
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void synchronize(List<Data> dataList) {
        int size = dataList.size();
        int numBatches = (size + batchSize - 1) / batchSize; // calculate the number of batches
        for (int i = 0; i < numBatches; i++) {
            int startIndex = i * batchSize;
            int endIndex = Math.min(startIndex + batchSize, size);
            List<Data> batch = dataList.subList(startIndex, endIndex);
            executorService.execute(() -> {
                for (Data data : batch) {
                    dataService.synchronizeData(data);
                }
            });
        }
        executorService.shutdown();
    }
}

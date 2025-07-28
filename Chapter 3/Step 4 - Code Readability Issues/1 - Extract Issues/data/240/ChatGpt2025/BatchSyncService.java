import java.util.List;

interface Syncable {
    void sync(); // method to synchronize the object data
    String getId(); // unique identifier for the object
}


public class BatchSyncService {

    /**
     * Synchronize a batch of Syncable objects.
     * 
     * @param items List of items implementing Syncable interface
     */
    public void batchSync(List<Syncable> items) {
        // Example: batch process them
        for (Syncable item : items) {
            // Could be a DB update, API call, etc.
            item.sync();
        }
        System.out.println("Batch synchronization completed for " + items.size() + " items.");
    }
}

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BatchSyncScheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    public void startPeriodicSync() {
        // Schedule to run every 30 minutes
        scheduler.scheduleAtFixedRate(this::syncData, 0, 30, TimeUnit.MINUTES);
    }
    
    private void syncData() {
        try {
            // Your synchronization logic here
            System.out.println("Running batch synchronization...");
            // Call your interface and process data
        } catch (Exception e) {
            System.err.println("Synchronization failed: " + e.getMessage());
        }
    }
    
    public void stop() {
        scheduler.shutdown();
    }
}

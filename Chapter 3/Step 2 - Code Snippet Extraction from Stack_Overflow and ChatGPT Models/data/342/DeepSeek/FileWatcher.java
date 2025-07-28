
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatcher {
    public static void main(String[] args) throws Exception {
        // Get the path to the directory you want to watch
        Path dir = Paths.get("path/to/directory");
        
        // Create the WatchService
        WatchService watcher = FileSystems.getDefault().newWatchService();
        
        // Register the directory with the WatchService
        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        
        System.out.println("Watching directory: " + dir);
        
        // Infinite loop to wait for events
        while (true) {
            WatchKey key;
            try {
                key = watcher.take(); // Wait for key to be signaled
            } catch (InterruptedException e) {
                return;
            }
            
            // Process all events for the key
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                
                // Get the filename from the event
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                
                System.out.printf("Event: %s, File: %s%n", kind.name(), filename);
                
                // Handle each event type
                if (kind == ENTRY_CREATE) {
                    // New file created
                } else if (kind == ENTRY_DELETE) {
                    // File deleted
                } else if (kind == ENTRY_MODIFY) {
                    // File modified
                }
            }
            
            // Reset the key - this step is crucial!
            boolean valid = key.reset();
            if (!valid) {
                break; // Directory no longer accessible
            }
        }
    }
}

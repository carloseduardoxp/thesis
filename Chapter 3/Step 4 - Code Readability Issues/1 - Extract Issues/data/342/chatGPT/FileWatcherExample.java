import java.nio.file.*;

public class FileWatcherExample {
    public static void main(String[] args) throws Exception {
        // create a WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();
        
        // register a path to be watched
        Path path = Paths.get("/path/to/watch");
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        
        // loop indefinitely to watch for file modifications
        while (true) {
            // wait for a key to be signaled
            WatchKey key = watchService.take();
            
            // process the events for the key
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
            }
            
            // reset the key
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}

import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.io.IOException;

public class FileWatcherExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Define the path to watch
        Path path = Paths.get("path/to/watch"); // change this to your directory

        // Create a WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Register the directory with the WatchService for specific events
        path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        System.out.println("Watching directory: " + path.toString());

        // Poll for events
        while (true) {
            WatchKey key = watchService.take(); // waits for a key to be available

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // The filename is the context of the event
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();

                System.out.println(kind.name() + ": " + filename);

                // You can add custom logic here for each event kind
            }

            // Reset the key -- this step is critical to receive further watch events.
            boolean valid = key.reset();
            if (!valid) {
                break; // loop exits if the directory is no longer accessible
            }
        }
    }
}

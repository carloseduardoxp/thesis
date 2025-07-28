import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
public class DirectoryWatcherService {

    private final WatchService watchService;
    private final Path dirToWatch;

    public DirectoryWatcherService(String dirPath) throws IOException {
        this.dirToWatch = Paths.get(dirPath);
        this.watchService = FileSystems.getDefault().newWatchService();
        dirToWatch.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    public void startWatching() {
        System.out.println("Watching directory: " + dirToWatch.toString());

        while (true) {
            WatchKey key;
            try {
                key = watchService.take();  // blocks until an event is available
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // Context is the relative path to the directory
                Path fileName = (Path) event.context();
                System.out.println("Event kind: " + kind + ". File affected: " + fileName);
            }

            boolean valid = key.reset();
            if (!valid) {
                break;  // exit loop if the key is no longer valid
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DirectoryWatcherService watcher = new DirectoryWatcherService("C:/example/path"); // Change to your path
        watcher.startWatching();
    }
}

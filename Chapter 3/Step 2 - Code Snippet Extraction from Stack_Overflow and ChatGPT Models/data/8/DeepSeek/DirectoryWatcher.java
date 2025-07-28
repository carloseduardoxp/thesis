import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class DirectoryWatcher {
    private final WatchService watcher;
    private final Path dir;

    public DirectoryWatcher(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dir = dir;
        register();
    }

    private void register() throws IOException {
        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    public void processEvents() {
        while (true) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == OVERFLOW) {
                    continue;
                }

                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                Path child = dir.resolve(filename);

                // Process the event
                System.out.printf("Event: %s, File: %s%n", kind.name(), child);
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("path/to/directory");
        new DirectoryWatcher(dir).processEvents();
    }
}

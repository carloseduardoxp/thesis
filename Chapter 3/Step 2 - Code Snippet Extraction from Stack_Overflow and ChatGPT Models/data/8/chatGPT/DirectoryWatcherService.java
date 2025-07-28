import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class DirectoryWatcherService {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path dir = Paths.get("path/to/your/directory");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Watching directory: " + dir.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.poll(10, TimeUnit.SECONDS);
            if (key == null) {
                System.out.println("No activity after 10 seconds");
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }

                Path path = ((WatchEvent<Path>) event).context();
                System.out.println(kind + " - " + path);
            }

            if (!key.reset()) {
                System.out.println("Key is no longer valid");
                break;
            }
        }
    }
}

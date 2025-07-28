import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class FileWatcherExample {

    private static final String DIRECTORY_TO_WATCH = "/tmp/watched_dir"; // Or adjust for Windows: "C:\\temp\\watched_dir"
    private static final String FILE_TO_WATCH = "my_important_file.txt";

    public static void main(String[] args) {
        Path dirPath;
        try {
            dirPath = setupWatchedDirectory();
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
            return;
        }

        Thread watcherThread = new Thread(() -> watchDirectory(dirPath), "FileWatcherThread");
        watcherThread.start();

        System.out.println("Main thread running. Press Ctrl+C to exit.");

        try {
            simulateFileOperations(dirPath);
        } finally {
            // Ensure the watcher thread is interrupted to allow clean shutdown
            watcherThread.interrupt();
        }
    }

    private static Path setupWatchedDirectory() throws IOException {
        Path dirPath = Paths.get(DIRECTORY_TO_WATCH);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
            System.out.println("Created directory: " + dirPath);
        }
        return dirPath;
    }

    private static void watchDirectory(Path dirPath) {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            registerForEvents(dirPath, watchService);
            System.out.println("Watching directory: " + dirPath);
            System.out.println("Looking for changes to: " + FILE_TO_WATCH);
            processEvents(watchService, dirPath);
        } catch (IOException e) {
            System.err.println("Error with WatchService: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("File watcher thread interrupted.");
        }
    }

    private static void registerForEvents(Path dirPath, WatchService watchService) throws IOException {
        dirPath.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY
        );
    }

    private static void processEvents(WatchService watchService, Path dirPath) throws InterruptedException {
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                handleEvent(event);
            }
            if (!key.reset()) {
                System.out.println("WatchKey is no longer valid for " + dirPath + ". Exiting watcher.");
                break;
            }
        }
    }

    private static void handleEvent(WatchEvent<?> event) {
        WatchEvent.Kind<?> kind = event.kind();
        if (kind == StandardWatchEventKinds.OVERFLOW) {
            return;
        }

        Path changedFile = (Path) event.context();
        if (isTargetFile(changedFile)) {
            System.out.println("Event kind: " + kind + ". File: " + changedFile.getFileName());
            logEventAction(kind);
        }
    }

    private static boolean isTargetFile(Path path) {
        return path != null && path.getFileName().toString().equals(FILE_TO_WATCH);
    }

    private static void logEventAction(WatchEvent.Kind<?> kind) {
        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
            System.out.println(FILE_TO_WATCH + " was created!");
        } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
            System.out.println(FILE_TO_WATCH + " was modified!");
        } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
            System.out.println(FILE_TO_WATCH + " was deleted!");
        }
    }

    private static void simulateFileOperations(Path dirPath) {
        Path targetFile = dirPath.resolve(FILE_TO_WATCH);
        System.out.println("\n--- Simulating file operations ---");

        try {
            TimeUnit.SECONDS.sleep(5);

            Files.write(targetFile, "Hello, watch service!".getBytes(), StandardOpenOption.CREATE);
            System.out.println("Created: " + targetFile);
            TimeUnit.SECONDS.sleep(2);

            Files.write(targetFile, "\nAdding more content.".getBytes(), StandardOpenOption.APPEND);
            System.out.println("Modified: " + targetFile);
            TimeUnit.SECONDS.sleep(2);

            Files.delete(targetFile);
            System.out.println("Deleted: " + targetFile);
            TimeUnit.SECONDS.sleep(2);

        } catch (IOException | InterruptedException e) {
            System.err.println("Simulation error: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("--- Simulation complete ---");
        }
    }
}

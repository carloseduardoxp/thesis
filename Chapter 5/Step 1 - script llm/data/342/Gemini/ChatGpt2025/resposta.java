import java.io.IOException;
import java.nio.file.*;

public class FileWatcherExample {

    private static final String DIRECTORY_TO_WATCH = "/tmp/watched_dir"; // Or adjust for Windows: "C:\\temp\\watched_dir"
    private static final String FILE_TO_WATCH = "my_important_file.txt";

    public static void main(String[] args) {
        Path dirPath = Paths.get(DIRECTORY_TO_WATCH);

        if (!ensureDirectoryExists(dirPath)) {
            return;
        }

        Thread watcherThread = new Thread(() -> watchFileEvents(dirPath), "FileWatcherThread");
        watcherThread.start();

        System.out.println("Main thread running. Press Ctrl+C to exit.");

        simulateFileOperations(dirPath, watcherThread);
    }

    private static boolean ensureDirectoryExists(Path dirPath) {
        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
                System.out.println("Created directory: " + dirPath);
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
            return false;
        }
    }

    private static void watchFileEvents(Path dirPath) {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            dirPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
            );

            System.out.println("Watching directory: " + dirPath);
            System.out.println("Looking for changes to: " + FILE_TO_WATCH);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                processWatchEvents(key, dirPath);
                if (!key.reset()) {
                    System.out.println("WatchKey is no longer valid for " + dirPath + ". Exiting watcher.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error with WatchService: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("File watcher thread interrupted.");
        }
    }

    private static void processWatchEvents(WatchKey key, Path dirPath) {
        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();
            Path changedFile = (Path) event.context();

            if (isTargetFile(changedFile)) {
                handleFileEvent(kind, changedFile);
            }
        }
    }

    private static boolean isTargetFile(Path changedFile) {
        return changedFile != null && changedFile.getFileName().toString().equals(FILE_TO_WATCH);
    }

    private static void handleFileEvent(WatchEvent.Kind<?> kind, Path changedFile) {
        System.out.println("Event kind: " + kind + ". File: " + changedFile.getFileName());

        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
            System.out.println(FILE_TO_WATCH + " was created!");
            // Perform actions on file creation
        } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
            System.out.println(FILE_TO_WATCH + " was modified!");
            // Perform actions on file modification
        } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
            System.out.println(FILE_TO_WATCH + " was deleted!");
            // Perform actions on file deletion
        }
    }

    private static void simulateFileOperations(Path dirPath, Thread watcherThread) {
        try {
            Thread.sleep(5000);

            Path targetFile = dirPath.resolve(FILE_TO_WATCH);

            System.out.println("\n--- Simulating file operations ---");

            Files.write(targetFile, "Hello, watch service!".getBytes(), StandardOpenOption.CREATE);
            System.out.println("Created: " + targetFile);
            Thread.sleep(2000);

            Files.write(targetFile, "\nAdding more content.".getBytes(), StandardOpenOption.APPEND);
            System.out.println("Modified: " + targetFile);
            Thread.sleep(2000);

            Files.delete(targetFile);
            System.out.println("Deleted: " + targetFile);
            Thread.sleep(2000);

            System.out.println("--- Simulation complete ---");

        } catch (IOException | InterruptedException e) {
            System.err.println("Simulation error: " + e.getMessage());
        } finally {
            watcherThread.interrupt();
        }
    }
}

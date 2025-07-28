import java.io.IOException;
import java.nio.file.*;

public class FileWatcherExample {

    private static final String DIRECTORY_TO_WATCH = "/tmp/watched_dir";
    private static final String FILE_TO_WATCH = "my_important_file.txt";

    public static void main(String[] args) {
        Path dirPath = Paths.get(DIRECTORY_TO_WATCH);

        if (!setupDirectory(dirPath)) {
            return;
        }

        Thread watcherThread = createWatcherThread(dirPath);
        watcherThread.start();

        System.out.println("Main thread running. Press Ctrl+C to exit.");
        simulateFileOperations(dirPath, watcherThread);
    }

    private static boolean setupDirectory(Path dirPath) {
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

    private static Thread createWatcherThread(Path dirPath) {
        return new Thread(() -> {
            try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
                registerWatchService(dirPath, watchService);
                processWatchEvents(watchService, dirPath);
            } catch (IOException e) {
                System.err.println("Error with WatchService: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("File watcher thread interrupted.");
            }
        }, "FileWatcherThread");
    }

    private static void registerWatchService(Path dirPath, WatchService watchService) throws IOException {
        dirPath.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY
        );
        System.out.println("Watching directory: " + dirPath);
        System.out.println("Looking for changes to: " + FILE_TO_WATCH);
    }

    private static void processWatchEvents(WatchService watchService, Path dirPath) throws InterruptedException {
        WatchKey key;
        while ((key = watchService.take()) != null) {
            processKeyEvents(key);
            if (!key.reset()) {
                System.out.println("WatchKey is no longer valid for " + dirPath + ". Exiting watcher.");
                break;
            }
        }
    }

    private static void processKeyEvents(WatchKey key) {
        for (WatchEvent<?> event : key.pollEvents()) {
            handleWatchEvent(event);
        }
    }

    private static void handleWatchEvent(WatchEvent<?> event) {
        WatchEvent.Kind<?> kind = event.kind();
        Path changedFile = (Path) event.context();

        if (isTargetFile(changedFile)) {
            System.out.println("Event kind: " + kind + ". File: " + changedFile.getFileName());
            handleFileEvent(kind);
        }
    }

    private static boolean isTargetFile(Path changedFile) {
        return changedFile != null && changedFile.getFileName().toString().equals(FILE_TO_WATCH);
    }

    private static void handleFileEvent(WatchEvent.Kind<?> kind) {
        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
            System.out.println(FILE_TO_WATCH + " was created!");
        } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
            System.out.println(FILE_TO_WATCH + " was modified!");
        } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
            System.out.println(FILE_TO_WATCH + " was deleted!");
        }
    }

    private static void simulateFileOperations(Path dirPath, Thread watcherThread) {
        try {
            Thread.sleep(5000);
            Path targetFile = dirPath.resolve(FILE_TO_WATCH);

            System.out.println("\n--- Simulating file operations ---");
            createFile(targetFile);
            modifyFile(targetFile);
            deleteFile(targetFile);
            System.out.println("--- Simulation complete ---");

        } catch (IOException | InterruptedException e) {
            System.err.println("Simulation error: " + e.getMessage());
        } finally {
            watcherThread.interrupt();
        }
    }

    private static void createFile(Path targetFile) throws IOException, InterruptedException {
        Files.write(targetFile, "Hello, watch service!".getBytes(), StandardOpenOption.CREATE);
        System.out.println("Created: " + targetFile);
        Thread.sleep(2000);
    }

    private static void modifyFile(Path targetFile) throws IOException, InterruptedException {
        Files.write(targetFile, "\nAdding more content.".getBytes(), StandardOpenOption.APPEND);
        System.out.println("Modified: " + targetFile);
        Thread.sleep(2000);
    }

    private static void deleteFile(Path targetFile) throws IOException, InterruptedException {
        Files.delete(targetFile);
        System.out.println("Deleted: " + targetFile);
        Thread.sleep(2000);
    }
}
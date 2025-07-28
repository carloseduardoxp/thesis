import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DirectoryWatcherService {

    private final WatchService watchService;
    private final Map<WatchKey, Path> watchedDirectories;
    private final ExecutorService executorService;
    private boolean isRunning = true;

    private static final String CREATED_DIRECTORY_MSG = "Created directory: ";

    /**
     * Constructor for DirectoryWatcherService.
     *
     * @param directoryToWatch The path to the directory to watch for changes.
     * It is crucial that this directory exists.
     * @throws IOException if the WatchService cannot be created or the directory cannot be registered.
     */
    public DirectoryWatcherService(Path directoryToWatch) throws IOException {
        if (!Files.exists(directoryToWatch)) {
            throw new IllegalArgumentException("Directory to watch does not exist: " + directoryToWatch);
        }

        this.watchService = FileSystems.getDefault().newWatchService();
        this.watchedDirectories = new HashMap<>();
        this.executorService = Executors.newSingleThreadExecutor(); // Use a single thread for watching

        // Register the directory and subdirectories (recursively)
        registerAll(directoryToWatch);
    }

    /**
     * Recursively registers the directory and all its subdirectories with the WatchService.
     *
     * @param dir The directory to register.
     * @throws IOException if a directory cannot be registered.
     */
    private void registerAll(final Path dir) throws IOException {
        // Register the directory with the WatchService
        WatchKey key = dir.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        watchedDirectories.put(key, dir);

        // Walk the directory tree and register all subdirectories
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path subDir, BasicFileAttributes attrs) throws IOException {
                // Register each subdirectory with the WatchService
                WatchKey subKey = subDir.register(watchService,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_MODIFY,
                        StandardWatchEventKinds.ENTRY_DELETE);
                watchedDirectories.put(subKey, subDir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Starts the directory watching service.  This method starts a thread
     * that will continuously monitor the registered directory for changes.
     *
     * The thread will process events and print information about the changes
     * to the console.  This method does not return until the service is stopped.
     */
    public void start() {
        executorService.submit(() -> {
            try {
                watchForChanges();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.err.println("Watcher thread interrupted: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("IO Exception in watcher thread: " + e.getMessage());
            } finally {
                // Cleanup resources
                try {
                    watchService.close();
                } catch (IOException e) {
                    System.err.println("Error closing watch service: " + e.getMessage());
                }
            }
        });
    }

    /**
     * Stops the directory watching service.  This method sets the isRunning
     * flag to false, which will cause the watchForChanges method to exit
     * after processing any pending events.  It also shuts down the
     * executor service, waiting for it to complete.
     */
    public void stop() {
        isRunning = false;
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS); // Give it some time to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Interrupted while waiting for executor to terminate: " + e.getMessage());
        }
    }

    /**
     * Method that continuously watches for changes in the registered directory.
     * This method is intended to be run in a separate thread.
     *
     * @throws InterruptedException if the thread is interrupted.
     * @throws IOException          if an I/O error occurs.
     */
    private void watchForChanges() throws InterruptedException, IOException {
        while (isRunning) {
            WatchKey key;
            try {
                // Poll for a key, waiting up to 5 seconds.  If no events are
                // available after 5 seconds, null is returned.
                key = watchService.poll(5, TimeUnit.SECONDS);
                if (key == null) {
                    continue; // No events, check if we should still be running
                }
            } catch (InterruptedException e) {
                // If the service is stopped, we should exit.
                if (!isRunning) {
                    break;
                }
                throw e; // Otherwise, re-throw the exception.
            }

            Path dir = watchedDirectories.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!");
                key.reset();
                continue;
            }

            boolean shouldBreak = false;
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // Handle OVERFLOW event
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    System.err.println("Overflow: Lost some events");
                    shouldBreak = true;
                    break;
                }

                // Get the name of the file/directory that was changed
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path name = ev.context();
                Path child = dir.resolve(name);

                // Print the event details
                System.out.printf("%s: %s%n", event.kind().name(), child);

                // If a new directory was created, register it and its subdirectories
                if (kind == StandardWatchEventKinds.ENTRY_CREATE && Files.isDirectory(child)) {
                    try {
                        registerAll(child); // Register the new directory and its subdirectories
                        System.out.println("Registered new directory: " + child);
                    } catch (IOException e) {
                        System.err.println("Error registering new directory: " + child + " - " + e.getMessage());
                    }
                }
            }

            // Reset the key. If the key is no longer valid, the loop terminates.
            boolean valid = key.reset();
            if (!valid) {
                watchedDirectories.remove(key);
                // if all directories are unregistered, stop watching.
                if (watchedDirectories.isEmpty()) {
                    break;
                }
            }
            if (shouldBreak) {
                continue;
            }
        }
    }

    /**
     * Main method to demonstrate the DirectoryWatcherService.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Specify the directory to watch.  Use a directory that exists.
            Path directoryToWatch = Paths.get("test_dir"); //  Use a valid directory for testing

            // Create the directory if it doesn't exist
            if (!Files.exists(directoryToWatch)) {
                Files.createDirectory(directoryToWatch);
                System.out.println(CREATED_DIRECTORY_MSG + directoryToWatch);
            }

            // Create some subdirectories for testing recursive watching
            Path subDir1 = directoryToWatch.resolve("subdir1");
            if (!Files.exists(subDir1)) {
                Files.createDirectory(subDir1);
                System.out.println(CREATED_DIRECTORY_MSG + subDir1);
            }
            Path subDir2 = directoryToWatch.resolve("subdir2");
            if (!Files.exists(subDir2)) {
                Files.createDirectory(subDir2);
                System.out.println(CREATED_DIRECTORY_MSG + subDir2);
            }

            // Create a file in the main directory
            Path testFile = directoryToWatch.resolve("test.txt");
            if (!Files.exists(testFile)) {
                Files.createFile(testFile);
                System.out.println("Created file: " + testFile);
            }
            // Create a file in a subdirectory
            Path testFile2 = subDir1.resolve("test2.txt");
            if (!Files.exists(testFile2)) {
                Files.createFile(testFile2);
                System.out.println("Created file: " + testFile2);
            }

            // Create the DirectoryWatcherService instance
            DirectoryWatcherService watcher = new DirectoryWatcherService(directoryToWatch);

            // Start the service in a new thread
            watcher.start();

            System.out.println("Directory watcher service started for: " + directoryToWatch);
            System.out.println("Watching for changes...");

            // Simulate some changes to the directory
            Thread.sleep(5000); // Wait for 5 seconds

            // Create a new file
            Files.createFile(directoryToWatch.resolve("new_file.txt"));
            System.out.println("Created file: new_file.txt");
            Thread.sleep(2000);

            // Modify the file
            Files.write(testFile, "Hello, world!".getBytes());
            System.out.println("Modified file: test.txt");
            Thread.sleep(2000);

            // Create a new directory
            Path newDir = directoryToWatch.resolve("new_dir");
            Files.createDirectory(newDir);
            System.out.println(CREATED_DIRECTORY_MSG + "new_dir");
            Thread.sleep(2000);

            //create file in new directory
            Files.createFile(newDir.resolve("anotherFile.txt"));
            System.out.println("Created file: anotherFile.txt");
            Thread.sleep(2000);

            // Delete a file
            Files.delete(testFile);
            System.out.println("Deleted file: test.txt");
            Thread.sleep(2000);

            // Delete a directory
            Files.delete(newDir);
            System.out.println("Deleted directory: new_dir");
            Thread.sleep(2000);

            // Stop the service
            watcher.stop();
            System.out.println("Directory watcher service stopped.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
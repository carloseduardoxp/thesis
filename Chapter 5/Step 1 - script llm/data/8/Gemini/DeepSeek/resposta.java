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

    public DirectoryWatcherService(Path directoryToWatch) throws IOException {
        if (!Files.exists(directoryToWatch)) {
            throw new IllegalArgumentException("Directory to watch does not exist: " + directoryToWatch);
        }

        this.watchService = FileSystems.getDefault().newWatchService();
        this.watchedDirectories = new HashMap<>();
        this.executorService = Executors.newSingleThreadExecutor();
        registerAll(directoryToWatch);
    }

    private void registerAll(final Path dir) throws IOException {
        WatchKey key = dir.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        watchedDirectories.put(key, dir);

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path subDir, BasicFileAttributes attrs) throws IOException {
                WatchKey subKey = subDir.register(watchService,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_MODIFY,
                        StandardWatchEventKinds.ENTRY_DELETE);
                watchedDirectories.put(subKey, subDir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void start() {
        executorService.submit(() -> {
            try {
                watchForChanges();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Watcher thread interrupted: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("IO Exception in watcher thread: " + e.getMessage());
            } finally {
                try {
                    watchService.close();
                } catch (IOException e) {
                    System.err.println("Error closing watch service: " + e.getMessage());
                }
            }
        });
    }

    public void stop() {
        isRunning = false;
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while waiting for executor to terminate: " + e.getMessage());
        }
    }

    private void watchForChanges() throws InterruptedException, IOException {
        while (isRunning) {
            WatchKey key = watchService.poll(5, TimeUnit.SECONDS);
            if (key == null) continue;

            Path dir = watchedDirectories.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!");
                key.reset();
                continue;
            }

            processEvents(key, dir);
            resetKey(key);
        }
    }

    private void processEvents(WatchKey key, Path dir) {
        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();

            if (kind == StandardWatchEventKinds.OVERFLOW) {
                System.err.println("Overflow: Lost some events");
                continue;
            }

            WatchEvent<Path> ev = (WatchEvent<Path>) event;
            Path name = ev.context();
            Path child = dir.resolve(name);

            System.out.printf("%s: %s%n", event.kind().name(), child);

            if (kind == StandardWatchEventKinds.ENTRY_CREATE && Files.isDirectory(child)) {
                try {
                    registerAll(child);
                    System.out.println("Registered new directory: " + child);
                } catch (IOException e) {
                    System.err.println("Error registering new directory: " + child + " - " + e.getMessage());
                }
            }
        }
    }

    private void resetKey(WatchKey key) {
        if (!key.reset()) {
            watchedDirectories.remove(key);
            if (watchedDirectories.isEmpty()) {
                isRunning = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Path directoryToWatch = Paths.get("test_dir");
            if (!Files.exists(directoryToWatch)) {
                Files.createDirectory(directoryToWatch);
                System.out.println(CREATED_DIRECTORY_MSG + directoryToWatch);
            }

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

            Path testFile = directoryToWatch.resolve("test.txt");
            if (!Files.exists(testFile)) {
                Files.createFile(testFile);
                System.out.println("Created file: " + testFile);
            }

            Path testFile2 = subDir1.resolve("test2.txt");
            if (!Files.exists(testFile2)) {
                Files.createFile(testFile2);
                System.out.println("Created file: " + testFile2);
            }

            DirectoryWatcherService watcher = new DirectoryWatcherService(directoryToWatch);
            watcher.start();

            System.out.println("Directory watcher service started for: " + directoryToWatch);
            System.out.println("Watching for changes...");

            Thread.sleep(5000);
            Files.createFile(directoryToWatch.resolve("new_file.txt"));
            System.out.println("Created file: new_file.txt");
            Thread.sleep(2000);

            Files.write(testFile, "Hello, world!".getBytes());
            System.out.println("Modified file: test.txt");
            Thread.sleep(2000);

            Path newDir = directoryToWatch.resolve("new_dir");
            Files.createDirectory(newDir);
            System.out.println(CREATED_DIRECTORY_MSG + newDir);
            Thread.sleep(2000);

            Files.createFile(newDir.resolve("anotherFile.txt"));
            System.out.println("Created file: anotherFile.txt");
            Thread.sleep(2000);

            Files.delete(testFile);
            System.out.println("Deleted file: test.txt");
            Thread.sleep(2000);

            Files.delete(newDir);
            System.out.println("Deleted directory: new_dir");
            Thread.sleep(2000);

            watcher.stop();
            System.out.println("Directory watcher service stopped.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

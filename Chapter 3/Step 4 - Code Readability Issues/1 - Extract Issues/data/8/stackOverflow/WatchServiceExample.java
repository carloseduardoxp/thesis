import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public final class WatchServiceExample {

    public static void main(String[] args) throws Exception {
        //We'll use this watch service to monitor all directories we are interested in
        final WatchService watchService = FileSystems.getDefault().newWatchService();

        //We'll use this directory for the test in order not to create junk in the system
        final Path tempDirectory = Files.createTempDirectory("watch-service-example");
        System.out.println("Created temporary directory: " + tempDirectory.toAbsolutePath());

        for (int i = 0; i < 10; i++) {
            final Path watchedDir = Files.createDirectory(tempDirectory.resolve("watched_" + i));
            System.out.println("Created watched directory: " + watchedDir.toAbsolutePath());
            watchedDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        }

        System.out.println("Initialization complete. When you create an entry in the watch dirs you'll be notified.");
        while (true) {
            final WatchKey watchKey = watchService.take();
            final Watchable watchable = watchKey.watchable();

            //Since we are registering only paths in teh watch service, the watchables must be paths
            if (!(watchable instanceof Path)) {
                throw new AssertionError("The watchable should have been a Path");
            }

            final Path directory = (Path) watchable;
            System.out.println("Processing events for watched directory: " + directory);

            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println("Received event '"
                  + event.kind()
                  + "' for entry '"
                  + event.context()
                  + "' in watched directory '"
                  + directory + "'"
                );
            }

            if (!watchKey.reset()) {
                System.out.println("Failed to reset watch key: will not process more events");
                break;
            }
        }

        //Lets clean up after ourselves
        Files.walkFileTree(tempDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
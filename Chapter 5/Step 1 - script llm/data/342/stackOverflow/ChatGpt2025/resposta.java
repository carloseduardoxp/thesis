import java.io.File;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;

import static java.nio.file.StandardWatchEventKinds.*;

class FileWatcherException extends Exception {
    public FileWatcherException(String message, Throwable cause) {
        super(message, cause);
    }
    public FileWatcherException(String message) {
        super(message);
    }
}

abstract class FileWatcher {

    private Path folderPath;
    private String watchFile;

    public FileWatcher(String watchFile) {
        Path filePath = Paths.get(watchFile);

        boolean isRegularFile = Files.isRegularFile(filePath);

        if (!isRegularFile) {
            // Do not allow this to be a folder since we want to watch files
            throw new IllegalArgumentException(watchFile + " is not a regular file");
        }

        // This is always a folder
        folderPath = filePath.getParent();

        // Keep this relative to the watched folder
        this.watchFile = watchFile.replace(folderPath.toString() + File.separator, "");
    }

    public void watchFile() throws FileWatcherException {
        // We obtain the file system of the Path
        FileSystem fileSystem = folderPath.getFileSystem();

        // We create the new WatchService using the try-with-resources block
        try (WatchService service = fileSystem.newWatchService()) {
            // We watch for modification events
            folderPath.register(service, ENTRY_MODIFY);

            // Start the infinite polling loop
            while (true) {
                // Wait for the next event
                WatchKey watchKey = service.take();

                for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                    // Get the type of the event
                    Kind<?> kind = watchEvent.kind();

                    if (kind == ENTRY_MODIFY) {
                        Path watchEventPath = (Path) watchEvent.context();

                        // Call this if the right file is involved
                        if (watchEventPath.toString().equals(watchFile)) {
                            onModified();
                        }
                    }
                }

                if (!watchKey.reset()) {
                    // Exit if no longer valid
                    break;
                }
            }
        } catch (Exception e) {
            throw new FileWatcherException("Error occurred while watching the file.", e);
        }
    }

    public abstract void onModified();
}

class MyFileWatcher extends FileWatcher {

    public MyFileWatcher(String watchFile) {
        super(watchFile);
    }

    @Override
    public void onModified() {
        System.out.println("Modified!");
    }
}

public class Teste {

    public static void main(String[] args) {
        String watchFile = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Test.txt";
        FileWatcher fileWatcher = new MyFileWatcher(watchFile);
        try {
            fileWatcher.watchFile();
        } catch (FileWatcherException e) {
            e.printStackTrace();
        }
    }
}

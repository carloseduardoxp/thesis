import java.io.File;

public class DeleteFilesExample {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        deleteFiles(directory);
    }

    public static void deleteFiles(File directory) {
        // Get a list of all files and directories in the directory
        File[] files = directory.listFiles();

        // Traverse the list and delete each file or directory recursively
        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively delete files in the subdirectory
                deleteFiles(file);
            } else {
                // Delete the file
                file.delete();
            }
        }

        // Delete the empty directory
        directory.delete();
    }
}

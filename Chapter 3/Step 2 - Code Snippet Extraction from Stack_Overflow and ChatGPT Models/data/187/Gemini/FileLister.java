import java.io.File;

public class FileLister {

    public static void listFilesRecursive(String directoryPath) {
        File directory = new File(directoryPath);

        // Check if the provided path is a valid directory
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path: " + directoryPath);
            return;
        }

        listFilesRecursive(directory);
    }

    private static void listFilesRecursive(File directory) {
        // Get all files and subdirectories in the current directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // If it's a file, print its absolute path
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    // If it's a directory, print its path and recursively call the method
                    System.out.println("Directory: " + file.getAbsolutePath());
                    listFilesRecursive(file); // Recursive call
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage: Replace with the path to your desired folder
        String folderPath = "/path/to/your/folder"; 
        // For example, on Windows: "C:\\Users\\YourUser\\Documents"
        // On Linux/macOS: "/home/youruser/documents"

        listFilesRecursive(folderPath);
    }
}

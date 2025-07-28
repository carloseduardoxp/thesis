import java.io.File;

public class RenameFiles {
    public static void main(String[] args) {
        // Folder path
        String folderPath = "path/to/your/folder";

        // Create a File object for the folder
        File folder = new File(folderPath);

        // List all files in the folder
        File[] files = folder.listFiles();

        if (files != null) {
            int count = 1; // Counter for new filenames
            for (File file : files) {
                if (file.isFile()) { // Ensure it is a file
                    // New file name, e.g., "file1.txt", "file2.txt", etc.
                    String newName = "file" + count + getFileExtension(file.getName());
                    File newFile = new File(folder, newName);

                    // Rename file
                    boolean success = file.renameTo(newFile);
                    if (success) {
                        System.out.println("Renamed: " + file.getName() + " to " + newName);
                    } else {
                        System.out.println("Failed to rename: " + file.getName());
                    }
                    count++;
                }
            }
        } else {
            System.out.println("Folder not found or it is empty.");
        }
    }

    // Helper method to get file extension
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex);
        } else {
            return "";
        }
    }
}

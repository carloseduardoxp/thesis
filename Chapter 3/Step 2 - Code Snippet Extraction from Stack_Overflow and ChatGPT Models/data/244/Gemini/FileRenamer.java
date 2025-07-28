import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        // 1. Create a File object for the original file
        File originalFile = new File("path/to/your/folder/oldname.txt"); // Replace with your actual path

        // 2. Create a File object for the new file
        File newFile = new File("path/to/your/folder/newname.txt"); // Replace with your actual path

        // 3. Call renameTo()
        if (originalFile.renameTo(newFile)) {
            System.out.println("File renamed successfully from " + originalFile.getName() + " to " + newFile.getName());
        } else {
            System.err.println("Failed to rename file " + originalFile.getName());
            // You might want to add more specific error handling here
            // e.g., check if the original file exists, check permissions, etc.
        }
    }
}

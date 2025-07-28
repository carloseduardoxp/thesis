import java.io.File;

public class Teste {
    public static void main(String[] args) {
        // Create a File object for the file to be deleted
        File file = new File("path/to/file.txt");

        // Check if the file exists
        if (file.exists()) {
            // Try to delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully!");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}

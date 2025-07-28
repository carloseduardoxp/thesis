import java.io.File;

public class Gemini {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt"; // Replace with the actual path
        File fileToDelete = new File(filePath);

        if (fileToDelete.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}

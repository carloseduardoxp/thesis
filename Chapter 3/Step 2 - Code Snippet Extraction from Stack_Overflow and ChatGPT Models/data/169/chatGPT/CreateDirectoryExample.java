import java.io.File;

public class CreateDirectoryExample {
    public static void main(String[] args) {
        String directoryPath = "/path/to/new/directory";

        File directory = new File(directoryPath);

        if (directory.mkdirs()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Failed to create directory");
        }
    }
}

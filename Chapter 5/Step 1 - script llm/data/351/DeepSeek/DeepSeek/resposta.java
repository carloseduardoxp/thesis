import java.io.InputStream;

public class DeepSeek {

    public static void main(String[] args) {
        // For files in src/main/resources
        getClass().getClassLoader().getResourceAsStream("filename.txt");

        // For files in a subdirectory of resources
        getClass().getClassLoader().getResourceAsStream("subdir/filename.txt");
    }
}

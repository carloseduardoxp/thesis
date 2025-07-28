
import java.io.InputStream;


public class DeepSeek {

    public static void main(String[] args) {

// For files in src/main/resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("filename.txt");

// For files in a subdirectory of resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("subdir/filename.txt");

    }

}

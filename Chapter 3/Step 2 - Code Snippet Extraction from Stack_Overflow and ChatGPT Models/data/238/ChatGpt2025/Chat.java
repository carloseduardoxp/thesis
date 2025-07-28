import java.io.*;

public class Chat {

    public static void main(String[] args) {

        InputStream inputStream = MyClass.class.getClassLoader().getResourceAsStream("path/to/file.txt");
        if (inputStream == null) {
            // file not found
        } else {
            // use the input stream
        }

    }

}

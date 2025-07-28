import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets; // For specifying character encoding

public class StringToInputStreamExample {
    public static void main(String[] args) {
        String myString = "Hello, this is a test string.";

        try {
            // Convert string to bytes using a specific charset (important!)
            byte[] bytes = myString.getBytes(StandardCharsets.UTF_8);

            // Create an InputStream from the byte array
            InputStream inputStream = new ByteArrayInputStream(bytes);

            // Now you can use 'inputStream' as needed, for example, to read from it
            int data = inputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputStream.read();
            }
            System.out.println("\nSuccessfully read from InputStream.");

            inputStream.close(); // Close the stream when done
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

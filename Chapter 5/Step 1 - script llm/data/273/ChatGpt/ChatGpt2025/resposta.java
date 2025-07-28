import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringToInputStreamExample {
   public static void main(String[] args) {
      // Create a string
      String str = "Hello, world!";

      // Convert the string to an input stream and use it directly
      // ...
      new ByteArrayInputStream(str.getBytes());
   }
}
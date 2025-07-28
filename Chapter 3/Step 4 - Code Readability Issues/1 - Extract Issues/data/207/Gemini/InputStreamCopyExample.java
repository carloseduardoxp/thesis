import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamCopyExample {

    public static void main(String[] args) throws IOException {
        String originalString = "Hello, Java 9+ streams!";
        InputStream originalInputStream = new ByteArrayInputStream(originalString.getBytes());

        // Copy the content to a ByteArrayOutputStream
        ByteArrayOutputStream copiedOutputStream = new ByteArrayOutputStream();
        originalInputStream.transferTo(copiedOutputStream);

        // Now you have the copied data in the copiedOutputStream
        byte[] copiedBytes = copiedOutputStream.toByteArray();
        InputStream newInputStream = new ByteArrayInputStream(copiedBytes);

        // You can now read from the newInputStream
        System.out.println("Original string: " + originalString);
        System.out.println("Copied string: " + new String(newInputStream.readAllBytes()));

        // Remember to close streams (though ByteArrayInputStream/OutputStream don't strictly need it)
        originalInputStream.close();
        copiedOutputStream.close();
        newInputStream.close();
    }
}

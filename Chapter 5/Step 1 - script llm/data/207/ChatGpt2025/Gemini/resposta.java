import java.io.*;

public class StreamCopyExample {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("input.txt");

        // Copy InputStream to ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }

        // Close original InputStream
        inputStream.close();

        // The data from the original input stream is now available in the 'baos' object.
        // You can create new InputStreams from it when needed, for example:
        // InputStream copy = new ByteArrayInputStream(baos.toByteArray());
    }
}

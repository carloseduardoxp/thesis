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

        // Create new InputStreams from the copied data as needed
        // Example usage:
        // InputStream copy = new ByteArrayInputStream(baos.toByteArray());
    }
}

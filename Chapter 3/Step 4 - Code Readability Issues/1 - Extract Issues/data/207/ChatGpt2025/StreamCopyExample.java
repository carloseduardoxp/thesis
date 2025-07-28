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

        // Create a new InputStream from the copied data
        InputStream copy1 = new ByteArrayInputStream(baos.toByteArray());
        InputStream copy2 = new ByteArrayInputStream(baos.toByteArray());

        // Now you can read from `copy1` and `copy2` independently
    }
}

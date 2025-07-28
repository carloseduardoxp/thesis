import java.io.*;

public class InputStreamCopy {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("sourceFile.txt");
        OutputStream outputStream = new FileOutputStream("destinationFile.txt");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
        System.out.println("File copied successfully.");
    }
}

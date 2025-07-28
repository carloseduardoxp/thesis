import java.io.*;
import java.util.zip.*;

public class ReadZipFile {
    public static void main(String[] args) {
        String zipFilePath = "example.zip";

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("File: " + entry.getName());

                // Optional: if you want to read the contents of each file
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zis.read(buffer)) > 0) {
                    baos.write(buffer, 0, length);
                }

                String fileContent = baos.toString("UTF-8");
                System.out.println("Content:\n" + fileContent);
                zis.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

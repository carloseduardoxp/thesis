import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UrlToZip {
    public static void main(String[] args) {
        String fileUrl = "https://example.com/file-to-download.pdf";
        String zipFileName = "downloaded_files.zip";
        String entryName = "downloaded_file.pdf"; // Name inside the zip

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName));
             BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream())) {
            
            // Create a new zip entry
            ZipEntry zipEntry = new ZipEntry(entryName);
            zos.putNextEntry(zipEntry);

            // Read from URL and write to zip
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            zos.closeEntry();
            System.out.println("File downloaded and added to zip successfully!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.URL;
import java.util.zip.*;

public class DownloadAndZip {
    public static void main(String[] args) {
        String fileURL = "https://example.com/file.txt"; // replace with your URL
        String zipFileName = "output.zip";
        String entryName = "file.txt"; // name inside zip

        try {
            // Download the file to memory
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (InputStream is = new URL(fileURL).openStream()) {
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
            }

            // Write to ZIP file
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {
                ZipEntry entry = new ZipEntry(entryName);
                zos.putNextEntry(entry);
                zos.write(baos.toByteArray());
                zos.closeEntry();
            }

            System.out.println("Downloaded and zipped successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

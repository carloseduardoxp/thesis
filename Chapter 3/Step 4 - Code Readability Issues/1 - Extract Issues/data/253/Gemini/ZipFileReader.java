import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileReader {

    public static void main(String[] args) {
        String zipFilePath = "path/to/your/archive.zip"; // Replace with your ZIP file path
        String destDirectory = "path/to/extract/to";   // Replace with your desired extraction directory

        try {
            unzip(zipFilePath, destDirectory);
            System.out.println("ZIP file extracted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error extracting ZIP file: " + e.getMessage());
        }
    }

    /**
     * Unzips a ZIP file to a specified destination directory.
     *
     * @param zipFilePath   The path to the ZIP file.
     * @param destDirectory The directory where the contents will be extracted.
     * @throws IOException If an I/O error occurs.
     */
    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir(); // Create the destination directory if it doesn't exist
        }

        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String entryName = entry.getName();
                File entryFile = new File(destDir, entryName);

                if (entry.isDirectory()) {
                    // Create directory if it's a directory entry
                    entryFile.mkdirs();
                } else {
                    // Ensure parent directories exist for the file
                    new File(entryFile.getParent()).mkdirs();

                    // Read content and write to file
                    try (InputStream is = new BufferedInputStream(zipFile.getInputStream(entry));
                         FileOutputStream fos = new FileOutputStream(entryFile);
                         BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                        byte[] buffer = new byte[4096]; // 4KB buffer
                        int bytesRead;
                        while ((bytesRead = is.read(buffer)) != -1) {
                            bos.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        }
    }
}

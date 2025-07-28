import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileDownloaderAndZipper {

    public static void main(String[] args) {
        String fileUrl = "https://www.example.com/somefile.txt"; // Replace with your file URL
        String downloadedFileName = "downloaded_file.txt"; // Name for the downloaded file
        String zipFileName = "archive.zip"; // Name for the output ZIP file
        String entryNameInZip = "my_downloaded_content.txt"; // Name of the file inside the ZIP

        try {
            // 1. Download the file from the URL
            File downloadedFile = downloadFile(fileUrl, downloadedFileName);
            System.out.println("File downloaded to: " + downloadedFile.getAbsolutePath());

            // 2. Put the downloaded file into a ZIP
            createZipWithFile(zipFileName, downloadedFile, entryNameInZip);
            System.out.println("File successfully zipped to: " + new File(zipFileName).getAbsolutePath());

            // Optional: Clean up the temporary downloaded file
            if (downloadedFile.delete()) {
                System.out.println("Temporary downloaded file deleted.");
            } else {
                System.out.println("Failed to delete temporary downloaded file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Downloads a file from a given URL to a local file.
     *
     * @param fileUrl      The URL of the file to download.
     * @param outputFileName The name of the local file to save the content to.
     * @return The File object representing the downloaded file.
     * @throws IOException If an I/O error occurs during download.
     */
    private static File downloadFile(String fileUrl, String outputFileName) throws IOException {
        URL url = new URL(fileUrl);
        URLConnection connection = url.openConnection(); // Open a connection to the URL

        try (InputStream in = new BufferedInputStream(connection.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {

            byte[] buffer = new byte[4096]; // Buffer for reading data
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }
        return new File(outputFileName);
    }

    /**
     * Creates a ZIP file containing a single specified file.
     *
     * @param zipFileName   The name of the ZIP file to create.
     * @param fileToZip     The File object of the file to add to the ZIP.
     * @param entryName     The name the file will have inside the ZIP archive.
     * @throws IOException If an I/O error occurs during ZIP creation.
     */
    private static void createZipWithFile(String zipFileName, File fileToZip, String entryName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(fileToZip)) {

            ZipEntry zipEntry = new ZipEntry(entryName);
            zos.putNextEntry(zipEntry); // Add the entry to the ZIP

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }
            zos.closeEntry(); // Close the current ZIP entry
        }
    }
}

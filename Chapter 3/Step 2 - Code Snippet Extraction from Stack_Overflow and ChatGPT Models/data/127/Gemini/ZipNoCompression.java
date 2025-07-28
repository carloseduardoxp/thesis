
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipNoCompression {

    public static void main(String[] args) {
        String sourceFilePath = "myFile.txt"; // The file to be added to the zip
        String zipFilePath = "myArchive.zip"; // The output zip file

        // 1. Create a dummy file for demonstration
        try {
            Path path = Paths.get(sourceFilePath);
            Files.write(path, "This is some content for my file.".getBytes());
            System.out.println("Created dummy file: " + sourceFilePath);
        } catch (IOException e) {
            System.err.println("Error creating dummy file: " + e.getMessage());
            return;
        }

        try {
            createZipStored(sourceFilePath, zipFilePath);
            System.out.println("ZIP file '" + zipFilePath + "' created with STORED compression.");
        } catch (IOException e) {
            System.err.println("Error creating ZIP file: " + e.getMessage());
        } finally {
            // Clean up the dummy file
            try {
                Files.deleteIfExists(Paths.get(sourceFilePath));
                System.out.println("Cleaned up dummy file: " + sourceFilePath);
            } catch (IOException e) {
                System.err.println("Error cleaning up dummy file: " + e.getMessage());
            }
        }
    }

    public static void createZipStored(String sourceFilePath, String zipFilePath) throws IOException {
        Path sourcePath = Paths.get(sourceFilePath);
        byte[] fileBytes = Files.readAllBytes(sourcePath);

        // Calculate CRC32 checksum
        CRC32 crc = new CRC32();
        crc.update(fileBytes);
        long crcValue = crc.getValue();

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            ZipEntry zipEntry = new ZipEntry(sourcePath.getFileName().toString());
            zipEntry.setMethod(ZipEntry.STORED); // Set the compression method to STORED
            zipEntry.setSize(fileBytes.length);   // Set the uncompressed size
            zipEntry.setCrc(crcValue);            // Set the CRC32 checksum

            zos.putNextEntry(zipEntry);
            zos.write(fileBytes);
            zos.closeEntry();
        }
    }
}

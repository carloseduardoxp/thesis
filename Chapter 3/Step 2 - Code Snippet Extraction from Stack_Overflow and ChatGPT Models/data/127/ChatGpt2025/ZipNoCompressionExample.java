import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class ZipNoCompressionExample {
    public static void main(String[] args) throws IOException {
        // File to zip
        Path sourceFile = Paths.get("example.txt");
        // Output ZIP file
        Path zipFile = Paths.get("example.zip");

        // Read all bytes for CRC and size calculation
        byte[] fileBytes = Files.readAllBytes(sourceFile);
        long fileSize = fileBytes.length;

        // Calculate CRC32 checksum
        CRC32 crc = new CRC32();
        crc.update(fileBytes);
        long checksum = crc.getValue();

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile.toFile()))) {
            ZipEntry entry = new ZipEntry(sourceFile.getFileName().toString());
            entry.setMethod(ZipEntry.STORED);
            entry.setSize(fileSize);
            entry.setCompressedSize(fileSize);
            entry.setCrc(checksum);

            zos.putNextEntry(entry);
            zos.write(fileBytes);
            zos.closeEntry();
        }

        System.out.println("ZIP created with no compression.");
    }
}

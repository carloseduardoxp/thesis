import java.io.*;
import java.util.zip.*;

public class StoredZipCreator {
    
    public static void main(String[] args) {
        String zipFileName = "uncompressed.zip";
        String[] filesToAdd = {"file1.txt", "file2.txt"}; // Replace with your files
        
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            // No need to set compression level - STORED method doesn't use it
            zos.setMethod(ZipOutputStream.STORED);
            
            for (String file : filesToAdd) {
                addToZipFile(file, zos);
            }
            
            System.out.println("ZIP file created successfully with STORED method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void addToZipFile(String fileName, ZipOutputStream zos) throws IOException {
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            ZipEntry entry = new ZipEntry(file.getName());
            
            // For STORED method, we need to set size, compressed size, and CRC
            byte[] bytes = fis.readAllBytes();
            
            entry.setMethod(ZipEntry.STORED);
            entry.setSize(file.length());
            entry.setCompressedSize(file.length());
            
            // Calculate CRC32 checksum
            CRC32 crc = new CRC32();
            crc.update(bytes);
            entry.setCrc(crc.getValue());
            
            zos.putNextEntry(entry);
            zos.write(bytes);
            zos.closeEntry();
        }
    }
}

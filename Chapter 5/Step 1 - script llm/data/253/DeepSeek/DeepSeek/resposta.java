import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipFileReader {
    private static final String BYTES_SUFFIX = " bytes";
    
    public static void main(String[] args) {
        String zipFilePath = "example.zip";
        
        try {
            // Method 1: Using ZipFile
            System.out.println("Reading zip file using ZipFile:");
            readUsingZipFile(zipFilePath);
            
            // Method 2: Using ZipInputStream
            System.out.println("\nReading zip file using ZipInputStream:");
            readUsingZipInputStream(zipFilePath);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void readUsingZipFile(String zipFilePath) throws IOException {
        ZipFile zipFile = new ZipFile(zipFilePath);
        
        // Iterate through all entries
        zipFile.stream().forEach(entry -> {
            System.out.println("Entry: " + entry.getName());
            System.out.println("Size: " + entry.getSize() + BYTES_SUFFIX);
            System.out.println("Compressed Size: " + entry.getCompressedSize() + BYTES_SUFFIX);
            
            // If you want to read the content of a specific entry
            if (!entry.isDirectory()) {
                try (InputStream inputStream = zipFile.getInputStream(entry)) {
                    // Read the content (example: first few bytes)
                    byte[] buffer = new byte[1024];
                    int bytesRead = inputStream.read(buffer);
                    System.out.println("First " + bytesRead + " bytes of content...");
                    // Process the content as needed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("----------------------");
        });
        
        zipFile.close();
    }
    
    public static void readUsingZipInputStream(String zipFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {
            
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Entry: " + entry.getName());
                System.out.println("Size: " + entry.getSize() + BYTES_SUFFIX);
                System.out.println("Compressed Size: " + entry.getCompressedSize() + BYTES_SUFFIX);
                
                if (!entry.isDirectory()) {
                    // Read the content (example: first few bytes)
                    byte[] buffer = new byte[1024];
                    int bytesRead = zis.read(buffer);
                    System.out.println("First " + bytesRead + " bytes of content...");
                    // Process the content as needed
                }
                System.out.println("----------------------");
                zis.closeEntry();
            }
        }
    }
}
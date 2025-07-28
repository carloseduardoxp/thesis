import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtractZip {
    public static void main(String[] args) throws IOException {
        // specify the path of the ZIP file
        String zipFilePath = "path/to/your/zipfile.zip";
        // specify the destination folder to extract to
        String destFolderPath = "path/to/your/destination/folder";
        
        // create a ZipFile object
        ZipFile zipFile = new ZipFile(zipFilePath);
        
        // get an enumeration of the ZIP file entries
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        
        // iterate through the entries and extract them one by one
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            String entryName = entry.getName();
            InputStream inputStream = zipFile.getInputStream(entry);
            OutputStream outputStream = new FileOutputStream(new File(destFolderPath, entryName));
            
            // read from the input stream and write to the output stream
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            
            // close the streams
            inputStream.close();
            outputStream.close();
        }
        
        // close the zip file
        zipFile.close();
        
        System.out.println("Extraction complete.");
    }
}

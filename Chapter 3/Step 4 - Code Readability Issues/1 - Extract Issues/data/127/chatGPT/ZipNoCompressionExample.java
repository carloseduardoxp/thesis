import java.io.*;
import java.util.zip.*;

public class ZipNoCompressionExample {
    public static void main(String[] args) throws IOException {
        String sourceFolder = "path/to/source/folder";
        String zipFile = "path/to/zip/file.zip";

        FileOutputStream fos = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);

        zos.setLevel(Deflater.NO_COMPRESSION);

        File folder = new File(sourceFolder);
        for (File file : folder.listFiles()) {
            FileInputStream fis = new FileInputStream(file);

            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipEntry.setSize(file.length());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
            zos.closeEntry();
        }

        zos.close();
        fos.close();
    }
}

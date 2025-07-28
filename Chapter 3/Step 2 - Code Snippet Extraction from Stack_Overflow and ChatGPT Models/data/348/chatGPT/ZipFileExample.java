import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.*;

public class ZipFileExample {
    public static void main(String[] args) {
        String urlStr = "https://example.com/myfile.txt"; // replace with your URL
        String fileName = "myfile.txt"; // replace with the name of the file to save
        String zipFileName = "myzip.zip"; // replace with the name of the ZIP file to create

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry(fileName);
            zos.putNextEntry(ze);

            FileInputStream in = new FileInputStream(fileName);
            buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();

            zos.closeEntry();
            zos.close();

            File fileToDelete = new File(fileName);
            fileToDelete.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

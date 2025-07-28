import java.io.*;
import java.net.*;

public class DownloadCSV {
    public static void main(String[] args) throws IOException {
        String fileURL = "https://example.com/data.csv";
        String saveDir = "C:\\downloads";
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());
            }
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + "\\" + fileName;
            FileWriter fileWriter = new FileWriter(saveFilePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
            bufferedReader.close();
            System.out.println("File downloaded successfully!");
        } else {
            System.out.println("Error downloading file.");
        }
        httpConn.disconnect();
    }
}

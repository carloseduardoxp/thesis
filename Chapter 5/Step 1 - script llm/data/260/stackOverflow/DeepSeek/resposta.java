import java.io.*;

public class Teste {

    public static void main(String[] args) {
        try {
            InputStream instream = openFileInput("E:\\test\\src\\com\\test\\mani.txt");
            if (instream != null) {
                readFileContents(instream);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static void readFileContents(InputStream instream) {
        try {
            InputStreamReader inputreader = new InputStreamReader(instream);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line;
            while ((line = buffreader.readLine()) != null) {
                // Process line if needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

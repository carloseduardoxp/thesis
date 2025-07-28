import java.io.*;

import javax.swing.JFileChooser;

public class Teste {

    public static void main(String[] args) {
        try {
            InputStream instream = openFileInput("E:\\test\\src\\com\\test\\mani.txt");
            if (instream != null) {
                readFile(instream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFile(InputStream instream) {
        try (InputStreamReader inputreader = new InputStreamReader(instream);
             BufferedReader buffreader = new BufferedReader(inputreader)) {
            String line;
            while ((line = buffreader.readLine()) != null) {
                // Process the line if needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dummy method to make the code compile
    private static InputStream openFileInput(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }
}

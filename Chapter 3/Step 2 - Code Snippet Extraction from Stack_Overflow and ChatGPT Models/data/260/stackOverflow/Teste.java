
import java.io.*;

import javax.swing.JFileChooser;

public class Teste {

    public static void main(String[] args) {
        try {
            InputStream instream = openFileInput("E:\\test\\src\\com\\test\\mani.txt");
            if (instream != null) {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line, line1 = "";
                try {
                    while ((line = buffreader.readLine()) != null) {
                        line1 += line;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            String error = "";
            error = e.getMessage();
        }
    }
}

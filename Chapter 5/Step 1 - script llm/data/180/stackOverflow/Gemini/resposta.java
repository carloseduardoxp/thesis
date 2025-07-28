import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Teste {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String nfdump = "nfdump -o csv -r /home/shane/Documents/nfdump/nfcapd.201211211526>blank.txt";

        try {
            FileWriter fw = new FileWriter("/home/shane/Documents/script.sh");

            PrintWriter pw = new PrintWriter(fw);

            pw.println("#!/bin/bash");
            pw.println(nfdump);

            pw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
             String[] env = {"PATH=/bin:/usr/bin/"};
             String cmd = "you complete shell command";  //e.g test.sh -dparam1 -oout.txt
             Runtime.getRuntime().exec(cmd, env);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teste {

    public static void main(String[] args) {        
        Process p = Runtime.getRuntime().exec("Your_Command");

        InputStream i = p.getInputStream();
    
        InputStreamReader isr = new InputStreamReader(i);
    
        BufferedReader br = new BufferedReader(isr);
    
    
        File f = new File("d:\\my.txt");
    
        FileWriter fw = new FileWriter(f);            // for appending use (f,true)
    
        BufferedWriter bw = new BufferedWriter(fw);
    
        while((br.readLine())!=null){
    
    
             bw.write(br.readLine());           // You can also use append.
        }
    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Teste {

    public static void main(String[] args) {
        try {
            BufferedWriter b = new BufferedWriter(
                    new FileWriter("/home/usr/Desktop/logger/logs.txt"));
            b.write("hello");

            //After writing close the resource
            b.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}

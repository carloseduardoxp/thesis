
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Teste {

    public static void main(String[] args) {        
        newStream = new ByteArrayInputStream(byteArrayOutputStream.toArray());
    }

    public static int copy(InputStream input, OutputStream output) throws IOException{
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
}
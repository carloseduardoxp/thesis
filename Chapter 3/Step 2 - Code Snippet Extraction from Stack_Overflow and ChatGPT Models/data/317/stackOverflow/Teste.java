
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

public class Teste {

    public static void main(String[] args) {        
        URLConnection connection = new URL("target").openConnection();
        File file = new File(connection.getURL().getPath().substring(1));
        FileChannel download = new FileOutputStream(file).getChannel();
        
        while(download.transferFrom(Channels.newChannel(connection.getInputStream()),
                file.length(), 1024) > 0) {
            //Some calculs to get current speed ;)
        }
    }
}
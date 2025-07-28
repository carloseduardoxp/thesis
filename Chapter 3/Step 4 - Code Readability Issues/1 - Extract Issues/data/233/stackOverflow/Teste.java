
import java.util.Arrays;
import java.util.logging.Handler;

public class Teste {

    public static void main(String[] args) {        
        Arrays.stream(log.getHandlers()).forEach(Handler::close);
    }
}
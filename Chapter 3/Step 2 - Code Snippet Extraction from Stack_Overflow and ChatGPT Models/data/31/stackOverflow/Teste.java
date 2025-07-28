import java.util.concurrent.atomic.AtomicInteger;

public class Teste {
    
    static final AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {        
        for (int j = 0; j<1000000; j++) {
            i.incrementAndGet();
        }    
    }
    
    


}
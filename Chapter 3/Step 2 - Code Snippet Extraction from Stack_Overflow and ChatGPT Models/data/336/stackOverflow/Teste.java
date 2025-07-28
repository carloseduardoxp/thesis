
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Teste {

    public static void main(String[] args) {        
        int numberOfTasks = 7;
        int batchSize = 1000;
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < numberOfTasks; i += batchSize) {
            final int start = i;
            final int last = Math.min(i + batchSize, numberOfTasks);
            es.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = start; j < last; j++)
                        System.out.println(j); // do something with j
                }
            });
        }
        es.shutdown();
    }
}
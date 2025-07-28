
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Teste {

    public static void main(String[] args) {
        final JavaSparkContext sc = new JavaSparkContext("local[2]", "Simple_App");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // Start thread 1
        Future<Long> future1 = executorService.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                JavaRDD<String> file1 = sc.textFile("/path/to/test_doc1");
                return file1.count();
            }
        });
        // Start thread 2
        Future<Long> future2 = executorService.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                JavaRDD<String> file2 = sc.textFile("/path/to/test_doc2");
                return file2.count();
            }
        });
        // Wait thread 1
        System.out.println("File1:" + future1.get());
        // Wait thread 2
        System.out.println("File2:" + future2.get());
    }
}

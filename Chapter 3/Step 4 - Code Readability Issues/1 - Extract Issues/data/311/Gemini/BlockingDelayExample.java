import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class BlockingDelayExample {

    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        Observable.just("Hello")
                .doOnNext(s -> {
                    System.out.println("Emitting '" + s + "' on thread: " + Thread.currentThread().getName());
                    try {
                        // This blocks the current thread!
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread interrupted during sleep.");
                    }
                    System.out.println("Resuming after sleep on thread: " + Thread.currentThread().getName());
                })
                .subscribe(
                        s -> System.out.println("Received: " + s + " on thread: " + Thread.currentThread().getName()),
                        Throwable::printStackTrace,
                        () -> System.out.println("Completed on thread: " + Thread.currentThread().getName())
                );

        // Keep main thread alive to see the output, as the Observable above will run synchronously
        // and finish before this. In a real application, you'd usually have a longer-running process.
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

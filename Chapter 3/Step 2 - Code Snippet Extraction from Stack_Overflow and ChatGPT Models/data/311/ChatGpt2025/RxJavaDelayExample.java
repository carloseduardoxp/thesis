import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class RxJavaDelayExample {
    public static void main(String[] args) {
        Observable.just("Hello")
            .delay(1, TimeUnit.SECONDS, Schedulers.trampoline())
            .subscribe(item -> System.out.println("Received: " + item + " on thread " + Thread.currentThread().getName()));

        System.out.println("After subscribe on thread " + Thread.currentThread().getName());
    }
}

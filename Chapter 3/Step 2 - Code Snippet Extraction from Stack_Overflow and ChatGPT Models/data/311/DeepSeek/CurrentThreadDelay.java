import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CurrentThreadDelay {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        Observable.just("Start")
            .doOnNext(s -> System.out.println("Before delay: " + Thread.currentThread().getName()))
            .delay(1, TimeUnit.SECONDS, Schedulers.trampoline())
            .doOnNext(s -> System.out.println("After delay: " + Thread.currentThread().getName()))
            .blockingSubscribe();
    }
}

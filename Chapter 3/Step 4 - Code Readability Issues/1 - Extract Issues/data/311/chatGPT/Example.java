import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class Example {
  public static void main(String[] args) {
    Observable.just("Hello, world!")
        .delaySubscription(1, TimeUnit.SECONDS, Schedulers.trampoline())
        .subscribe(System.out::println);
  }
}

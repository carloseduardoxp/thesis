public class Teste {

    public static void main(String[] args) {
        BlockingScheduler scheduler = new BlockingScheduler();

        scheduler.execute(() -> Flowable.range(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .doAfterTerminate(() -> scheduler.shutdown())
                .subscribe(v -> System.out.println(v + " on " + Thread.currentThread())));

        System.out.println("BlockingScheduler finished");
    }
}
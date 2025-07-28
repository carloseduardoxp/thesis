import java.lang.Thread.UncaughtExceptionHandler;

class MyExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread arg0, Throwable arg1) {
        System.out.println("[DEFAULT EXCEPTION HANDLER] Caught some exception");
    }
}

class MyThread extends Thread {
    public MyThread() {
        setUncaughtExceptionHandler(
            (t, e) -> System.out.println("[THREAD SPECIFIC] My exception handler")
        );
    }

    @Override
    public void run() {
        throw new MyThreadException();
    }
}

class MyThreadException extends RuntimeException {
    public MyThreadException() {
        super("Exception thrown from MyThread");
    }
}

class MainThreadException extends RuntimeException {
    public MainThreadException() {
        super("Exception thrown from main thread");
    }
}

public class Test {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
        new MyThread().start();
        // current thread does not have a thread specific exception handler
        throw new MainThreadException();
    }

}

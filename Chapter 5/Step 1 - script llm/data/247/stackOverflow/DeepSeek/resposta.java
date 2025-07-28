import java.lang.Thread.UncaughtExceptionHandler;

class MyExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("[DEFAULT EXCEPTION HANDLER] Caught some exception");
    }
}

class MyThread extends Thread {
    public MyThread() {
        setUncaughtExceptionHandler((t, e) -> System.out.println("[THREAD SPECIFIC] My exception handler"));
    }

    @Override
    public void run() {
        throw new MyCustomRuntimeException();
    }
}

class MyCustomRuntimeException extends RuntimeException {
    public MyCustomRuntimeException() {
        super("Custom runtime exception occurred");
    }
}

public class Test {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
        new MyThread().start();
        throw new MyCustomRuntimeException();
    }
}

class MyRunnable implements Runnable {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            // do work here
            System.out.println("Thread running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // preserve interrupt status
                break;
            }
        }
        System.out.println("Thread stopped.");
    }

    public void stop() {
        running = false;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(5000); // let thread run for 5 seconds
        task.stop();        // signal the thread to stop
        thread.join();      // wait for thread to finish
        System.out.println("Main finished.");
    }
}

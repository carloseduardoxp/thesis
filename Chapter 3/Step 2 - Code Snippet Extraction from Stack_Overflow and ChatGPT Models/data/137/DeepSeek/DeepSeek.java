
class StoppableThread implements Runnable {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            // Do some work
            try {
                Thread.sleep(1000);
                System.out.println("Thread is running...");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
            }
        }
        System.out.println("Thread stopped gracefully");
    }

    public void stopThread() {
        running = false;
    }
}

public class DeepSeek {

    public static void main(String[] args) {

        // Usage:
        StoppableThread task = new StoppableThread();
        Thread thread = new Thread(task);
        thread.start();

        // Later, when you want to stop the thread:
        task.stopThread();
    }
}

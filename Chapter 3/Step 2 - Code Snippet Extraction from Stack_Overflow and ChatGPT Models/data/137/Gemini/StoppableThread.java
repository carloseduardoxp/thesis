public class StoppableThread implements Runnable {
    private volatile boolean running = true; // 'volatile' ensures visibility across threads

    @Override
    public void run() {
        while (running) {
            // Your thread's main logic goes here
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                // If interrupted while sleeping, you might want to stop the thread
                // or just log the interruption and continue.
                // For graceful shutdown, often you'd set running = false here too.
                Thread.currentThread().interrupt(); // Re-interrupt the current thread
                running = false; // Exit the loop
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " has stopped.");
    }

    public void stopThread() {
        running = false;
    }

    public static void main(String[] args) {
        StoppableThread myTask = new StoppableThread();
        Thread thread = new Thread(myTask, "MyWorkerThread");
        thread.start();

        try {
            Thread.sleep(5000); // Let the thread run for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        myTask.stopThread(); // Request the thread to stop

        try {
            thread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main thread finished.");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running.");
        // Code to be executed by the thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + " : " + i);
            try {
                Thread.sleep(100); // Introduce a small delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " finished.");

    }
}

public class Gemini {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start(); // Start the first thread
        thread2.start(); // Start the second thread
        System.out.println("Main thread continues...");
        // Main thread continues its execution
        for (int i = 0; i < 3; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread finished.");
    }
}

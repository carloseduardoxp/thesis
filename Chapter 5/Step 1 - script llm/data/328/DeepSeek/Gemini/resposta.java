// Extending Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        // Task to be performed
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

// Implementing Runnable interface
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Task to be performed
        System.out.println("Runnable running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // Approach 1: Extending Thread
        MyThread thread1 = new MyThread();
        thread1.start();
        
        // Approach 2: Implementing Runnable
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
        
        // Approach 3: Lambda expression (Java 8+)
        Thread thread3 = new Thread(() -> System.out.println("Lambda running: " + Thread.currentThread().getName()));
        thread3.start();
    }
}
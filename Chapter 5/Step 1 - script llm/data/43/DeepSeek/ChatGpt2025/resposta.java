class MyThread extends Thread {
    @Override
    public void run() {
        // Code to execute in this thread
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Starts the thread
    }
}
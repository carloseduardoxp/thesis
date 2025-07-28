class MyThread extends Thread {
    @Override
    public void run() {
        // Code to be executed in the new thread
        System.out.println("Thread is running");
    }
}

public class DeepSeek {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Starts the thread and calls run()
    }
}

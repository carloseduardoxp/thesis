public class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed in this thread
    }
}

class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

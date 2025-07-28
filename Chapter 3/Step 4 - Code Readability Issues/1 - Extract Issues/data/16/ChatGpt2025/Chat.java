public class Chat extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        Chat t1 = new Chat(); // create thread
        t1.start(); // start thread
    }
}

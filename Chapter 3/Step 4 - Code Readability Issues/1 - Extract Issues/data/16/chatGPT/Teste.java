public class Teste implements Runnable {
    public void run() {
        // Code to be executed in the thread
    }

    public static void main(String[] args) {
        Teste myRunnable = new Teste();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

class MyThread extends Thread {
  public void run() {
      while (!isInterrupted()) {
          // Do some work
      }
      System.out.println("Thread interrupted");
  }
}

public class Main {
  public static void main(String[] args) {
      // Create a new thread
      MyThread t = new MyThread();
      
      // Start the thread
      t.start();

      // Sleep for 5 seconds
      try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      
      // Interrupt the thread
      t.interrupt();
  }
}

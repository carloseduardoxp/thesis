class Sender implements Runnable {
  private String message;
  
  public Sender(String message) {
      this.message = message;
  }
  
  public void run() {
      // Send the message asynchronously
      // ...
      System.out.println("Sent message: " + message);
  }
}

public class Main {
  public static void main(String[] args) {
      // Create a new thread to send the message
      Thread thread = new Thread(new Sender("Hello, world!"));
      thread.start();
      
      // Do some other work asynchronously while the message is being sent
      // ...
  }
}

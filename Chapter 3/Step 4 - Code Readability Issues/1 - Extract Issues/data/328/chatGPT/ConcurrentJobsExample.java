public class ConcurrentJobsExample {
  public static void main(String[] args) {
      Thread job1 = new Thread(() -> {
          System.out.println("Job 1 started");
          // do some work
          System.out.println("Job 1 finished");
      });

      Thread job2 = new Thread(() -> {
          System.out.println("Job 2 started");
          // do some work
          System.out.println("Job 2 finished");
      });

      // start both threads
      job1.start();
      job2.start();

      // wait for both threads to finish
      try {
          job1.join();
          job2.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      System.out.println("Both jobs finished");
  }
}

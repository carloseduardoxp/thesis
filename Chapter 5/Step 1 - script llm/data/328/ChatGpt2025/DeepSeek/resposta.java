class MyJob extends Thread {
    @Override
    public void run() {
        System.out.println("Job running in thread: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyJob job1 = new MyJob();
        MyJob job2 = new MyJob();

        job1.start();
        job2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from a new thread!");
        // Your thread's logic goes here
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread: " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start(); // Start the execution of the thread

        System.out.println("Hello from the main thread!");
        for (int i = 0; i < 3; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted!");
            }
        }
    }
}

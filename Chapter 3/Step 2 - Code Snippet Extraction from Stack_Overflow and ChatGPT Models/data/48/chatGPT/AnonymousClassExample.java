public class AnonymousClassExample {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class!");
            }
        });

        t.start();
    }
}

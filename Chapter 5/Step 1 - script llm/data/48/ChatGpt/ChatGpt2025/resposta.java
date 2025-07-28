public class AnonymousClassExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello from anonymous class!"));
        t.start();
    }
}
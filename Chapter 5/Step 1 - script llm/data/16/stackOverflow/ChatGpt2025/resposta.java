public class Teste {

    public static void main(String[] args) {
        Thread someThread = new Thread(() -> runSomething());
        someThread.setDaemon(true);
        someThread.start();
    }

}
public class Teste {

    public static void main(String[] args) {
        Thread someThread = new Thread(new Runnable() {
            @Override
            public void run() {
                runSomething();
            }
        });
        someThread.setDaemon(true);
        someThread.start();
    }

}
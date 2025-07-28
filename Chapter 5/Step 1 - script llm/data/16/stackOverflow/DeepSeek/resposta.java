public class Teste {

    public static void main(String[] args) {
        Thread someThread = new Thread(Teste::runSomething);
        someThread.setDaemon(true);
        someThread.start();
    }

}

class MinhaThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread executando!");
    }

    public static void main(String[] args) {
        MinhaThread t = new MinhaThread();
        t.start();  // Não use t.run()!
    }
}
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CancelSupport {

    public static class CommandExecutor implements Runnable {

        private BlockingQueue<String> queue;
        public static final String POISON_PILL = "stopnow";

        public CommandExecutor(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            boolean stop = false;
            while (!stop) {
                try {
                    String command = queue.take();
                    if (POISON_PILL.equals(command)) {
                        stop = true;
                    } else {
                        // do command
                        System.out.println(command);
                    }
                } catch (InterruptedException e) {
                    stop = true;
                }
            }
            System.out.println("Stopping execution");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Thread t = new Thread(new CommandExecutor(queue));
        queue.put("hello");
        queue.put("world");
        t.start();
        Thread.sleep(1000);
        queue.put(CommandExecutor.POISON_PILL);
    }
}
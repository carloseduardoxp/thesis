import java.util.*;
import java.util.concurrent.*;

@RequiredArgsConstructor
public class TestThread implements Runnable {

    private final Queue<String> queue;
    private final Publisher publisher;
    private final int maxBatchSize;

    @Override
    public void run() {
        while (!stopWork) {
            try {
                // wait for messages with 10 seconds timeout,if no message or timeout return empty list
                // this is easy to impl with BlockingQueue
                List<String> events = queue.poll(10, TimeUnit.SECOND);
                if (events.isEmpty()) {
                    continue;
                }
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                    @Override
                    public void run() {
                        pushEvents(events, true);
                    }
                }, 1000 * 10);
            } catch (Exception e) {
                // Log and do something
            }
        }
    }

    private void pushEvents(List<String> events, boolean forcePush) {
        if (events.size() >= maxBatchSize || forcePush) {
            pushToHTTPEndPoint(events);
            events.clear();
        }
    }

    private void pushToHTTPEndPoint(List<String> events) {
        publisher.publish(events);
    }
}
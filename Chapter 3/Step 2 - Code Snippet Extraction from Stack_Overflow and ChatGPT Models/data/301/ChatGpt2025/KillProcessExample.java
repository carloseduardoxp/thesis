import java.io.IOException;

public class KillProcessExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Start a process (for example, pinging google)
        Process process = new ProcessBuilder("ping", "google.com").start();

        // Let the process run for 5 seconds
        Thread.sleep(5000);

        // Kill the process politely
        process.destroy();

        // Optionally, wait to see if it has terminated
        boolean exited = process.waitFor(5, java.util.concurrent.TimeUnit.SECONDS);
        if (!exited) {
            // If it didn't exit in 5 seconds, force kill it
            process.destroyForcibly();
        }

        System.out.println("Process killed");
    }
}

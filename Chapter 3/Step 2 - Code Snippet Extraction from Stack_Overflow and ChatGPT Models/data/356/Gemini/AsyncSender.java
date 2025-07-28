
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AsyncSender {

    public static void main(String[] args) {
        String dataToSend = "Hello, asynchronous world!";
        String host = "localhost"; // Replace with your target host
        int port = 12345;          // Replace with your target port

        // Start a new thread to send data
        new Thread(() -> {
            try {
                sendData(host, port, dataToSend);
                System.out.println("Data sent asynchronously.");
            } catch (IOException e) {
                System.err.println("Error sending data: " + e.getMessage());
            }
        }).start();

        System.out.println("Main thread continues execution...");
        // The main thread can do other work here
    }

    private static void sendData(String host, int port, String data) throws IOException {
        try (Socket socket = new Socket(host, port);
             OutputStream os = socket.getOutputStream()) {
            os.write(data.getBytes(StandardCharsets.UTF_8));
            os.flush();
            System.out.println("Data successfully written to socket: " + data);
        }
    }
}

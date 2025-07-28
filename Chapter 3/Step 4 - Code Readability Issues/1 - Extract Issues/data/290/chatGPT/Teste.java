
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import javax.websocket.server.ServerContainer;
import org.glassfish.tyrus.server.Server;

@ServerEndpoint("/websocket")
public class MyWebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        System.out.println("Received message: " + message);
        session.getBasicRemote().sendText("Echo: " + message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket closed: " + session.getId());
    }
}

public class MyWebSocketServerLauncher {

    public static void main(String[] args) {
        Server server = new Server("localhost", 8080, "/myapp", MyWebSocketServer.class);
        try {
            server.start();
            ServerContainer container = (ServerContainer) server.getWebSocketServerContainer();
            System.out.println("WebSocket server started");
            System.out.println("WebSocket endpoint: " + container.getWebSockets().get(0).getPath());
            System.out.println("Press enter to stop the server");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}

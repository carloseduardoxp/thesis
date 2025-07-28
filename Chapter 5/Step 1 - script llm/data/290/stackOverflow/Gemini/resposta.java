import org.json.JSONObject;

public class Teste {

    public static void main(String[] args) {

        WebSocketClient mWs = new WebSocketClient(new URI("ws://socket.example.com:1234"), new Draft_10()) {
            @Override
            public void onMessage(String message) {
                // The unused local variables were removed as they served no purpose.
            }

            @Override
            public void onOpen(ServerHandshake handshake) {
                System.out.println("opened connection");
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("closed connection");
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }

        };
        //open websocket
        mWs.connect();
        JSONObject obj = new JSONObject();
        obj.put("event", "addChannel");
        obj.put("channel", "ok_btccny_ticker");
        String message = obj.toString();
        //send message
        mWs.send(message);
    }
}

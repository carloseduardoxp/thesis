import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttExample {
    private static final String BROKER = "tcp://broker.hivemq.com:1883";
    private static final String CLIENT_ID = "JavaClient";
    private static final String TOPIC = "java/mqtt/example";
    
    public static void main(String[] args) {
        try {
            // Set up persistence for messages
            MqttClientPersistence persistence = new MemoryPersistence();
            
            // Initialize client
            IMqttClient client = new MqttClient(BROKER, CLIENT_ID, persistence);
            
            // Set up connection options
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            
            // Connect to broker
            client.connect(options);
            System.out.println("Connected to broker: " + BROKER);
            
            // Subscribe to topic
            client.subscribe(TOPIC, (topic, msg) -> {
                byte[] payload = msg.getPayload();
                System.out.println("Received message: " + new String(payload));
            });
            
            // Publish a message
            String content = "Hello from Java MQTT client";
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(0); // Quality of Service level
            client.publish(TOPIC, message);
            System.out.println("Message published: " + content);
            
            // Disconnect
            client.disconnect();
            System.out.println("Disconnected");
            
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

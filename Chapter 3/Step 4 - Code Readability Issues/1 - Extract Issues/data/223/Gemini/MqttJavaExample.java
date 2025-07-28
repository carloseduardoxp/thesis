import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttJavaExample {

    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883"; // Public test broker
    private static final String CLIENT_ID = "JavaExampleClient";
    private static final String TOPIC = "my/test/topic";
    private static final int QOS = 1; // Quality of Service

    public static void main(String[] args) {
        try {
            // Create MQTT client
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID, new MemoryPersistence());

            // Set up connection options
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true); // Start with a clean session (no previous subscriptions/messages)
            options.setAutomaticReconnect(true); // Automatically try to reconnect if connection is lost
            options.setKeepAliveInterval(60); // Send a ping every 60 seconds to keep connection alive

            // Set a callback listener for incoming messages
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Message received:");
                    System.out.println("\tTopic: " + topic);
                    System.out.println("\tMessage: " + new String(message.getPayload()));
                    System.out.println("\tQoS: " + message.getQos());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("Message delivered to broker: " + token.getMessageId());
                }
            });

            // Connect to the broker
            System.out.println("Connecting to broker: " + BROKER_URL);
            client.connect(options);
            System.out.println("Connected to broker.");

            // Subscribe to a topic
            client.subscribe(TOPIC, QOS);
            System.out.println("Subscribed to topic: " + TOPIC);

            // Publish a message
            String content = "Hello, MQTT from Java! " + System.currentTimeMillis();
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(QOS);
            client.publish(TOPIC, message);
            System.out.println("Message published: " + content);

            // Keep the application running for a while to receive messages
            Thread.sleep(5000); // Wait for 5 seconds to receive any messages

            // Disconnect and close the client
            client.disconnect();
            System.out.println("Disconnected from broker.");
            client.close();

        } catch (MqttException e) {
            System.err.println("MQTT Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}

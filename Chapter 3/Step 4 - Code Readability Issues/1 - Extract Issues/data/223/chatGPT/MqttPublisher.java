import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublisher {
    public static void main(String[] args) throws MqttException {
        String brokerUrl = "tcp://mqtt.eclipseprojects.io:1883";
        String clientId = "JavaPublisher";
        MqttClient client = new MqttClient(brokerUrl, clientId);
        client.connect();
        String topic = "my/topic";
        String message = "Hello, MQTT!";
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        client.publish(topic, mqttMessage);
        client.disconnect();
    }
}

import org.eclipse.paho.client.mqttv3.*;

public class SimpleMqttExample {

    public static void main(String[] args) {

        String broker = "tcp://broker.hivemq.com:1883"; // broker público de teste
        String clientId = "JavaSampleClient";
        String topic = "test/topic";

        try {
            // Cria cliente MQTT
            MqttClient client = new MqttClient(broker, clientId);

            // Configura callback para receber mensagens
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Conexão perdida!");
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Mensagem recebida no tópico " + topic + ": " + message.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("Entrega completada.");
                }
            });

            // Conecta ao broker
            client.connect();

            // Inscreve no tópico
            client.subscribe(topic);

            // Publica uma mensagem no tópico
            String content = "Olá MQTT!";
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(1); // nível de QoS 1 (pelo menos uma vez)
            client.publish(topic, message);

            System.out.println("Mensagem publicada.");

            // Mantém o programa rodando para receber mensagens
            Thread.sleep(5000);

            client.disconnect();
            System.out.println("Desconectado.");

        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

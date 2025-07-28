import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String ORDER_TOPIC = "order-events";

    public OrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createOrder(String orderDetailsJson) {
        // Logic to create order...
        System.out.println("Creating order: " + orderDetailsJson);
        // Send order creation event to Kafka
        kafkaTemplate.send(ORDER_TOPIC, "order-key-123", orderDetailsJson);
    }
}

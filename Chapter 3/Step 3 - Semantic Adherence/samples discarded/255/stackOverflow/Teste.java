class MyProducer {

    @Autowired
    private KafkaTemplate<String, ?> kafka;

    public void send(String topic, Message<?> message) {
        kafka.setDefaultTopic(topic);
        kafka.send(message);
    }
}

@Configuration
public class MyProducerConfig {

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        ...

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
        kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());

        return kafkaTemplate;
    }
}

public class Teste {

    public static void main(String[] args) {        
        ProducerRecord<?, ?> producerRecord = kafka.getMessageConverter().fromMessage(message, topic);
        kafka.send(producerRecord);
    }
}
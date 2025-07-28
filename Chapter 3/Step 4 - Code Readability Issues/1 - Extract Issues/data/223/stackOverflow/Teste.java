public class Teste {

    public static void main(String[] args) {
        String userName = "Ohelig";
        String password = "Pojke";
        MqttClient client = new MqttClient("tcp://192.168.1.4:1883", "Sending");
        MqttConnectOptions authen = new MqttConnectOptions();
        authen.setUserName(userName);
        authen.setPassword(password.toCharArray());
        authen.setKeepAliveInterval(30);
        authen.setConnectionTimeout(300);

        client.connect(authen);
    }
}

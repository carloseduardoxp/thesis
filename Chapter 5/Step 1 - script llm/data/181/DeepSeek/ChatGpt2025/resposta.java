public class DeepSeek {

    public static void main(String[] args) {

        String text = "Hello\nWorld\r\nJava";
        String result = text.replaceAll("[\\r\\n]", "");
        System.out.println(result); // Output: HelloWorldJava

    }

}
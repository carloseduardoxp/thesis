public class EscapeQuotes {
    public static void main(String[] args) {
        String message = "He said, \"Hello there!\"";
        System.out.println(message);

        String path = "C:\\Program Files\\Java"; // Escaping backslashes themselves
        System.out.println(path);

        String jsonString = "{\"name\": \"John Doe\", \"age\": 30}"; // Escaping quotes in JSON
        System.out.println(jsonString);
    }
}

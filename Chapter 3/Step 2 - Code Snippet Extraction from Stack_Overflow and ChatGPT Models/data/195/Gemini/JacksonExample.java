public class JacksonExample {
    public static void main(String[] args) {
        String originalString = "This string has \"quotes\", a \\backslash\\, a /slash/, and a newline.\nAlso, some tabs\t.";

        try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a simple object to hold the string
            class Message {
                public String text;
                public Message(String text) { this.text = text; }
                // Getters and setters (or use public fields)
                public String getText() { return text; }
                public void setText(String text) { this.text = text; }
            }

            Message message = new Message(originalString);

            // Serialize the object to a JSON string
            String jsonString = objectMapper.writeValueAsString(message);
            System.out.println("Original String: " + originalString);
            System.out.println("JSON String (Jackson): " + jsonString);

            // Example of creating a JSON with a raw value if needed (less common for escaping)
            // If you have a string that is ALREADY JSON-escaped and you don't want Jackson to re-escape it
            // you might use @JsonRawValue, but for typical use cases, Jackson handles it.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

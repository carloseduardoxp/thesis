public class Chat {

    public static void main(String[] args) {

        String escaped = new ObjectMapper().writeValueAsString("Text with \"quotes\"");

    }

}
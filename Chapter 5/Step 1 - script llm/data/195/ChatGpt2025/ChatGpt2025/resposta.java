public class Chat {

    public static void main(String[] args) throws Exception {

        System.out.println(new ObjectMapper().writeValueAsString("Text with \"quotes\""));

    }

}
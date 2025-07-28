
public class Example {
    public static void main(String[] args) {
        String text = "Lorem, ipsum dolor sit amet; consectetur adipiscing elit.";
        String[] tokens = text.split("[,;.]\\s*");

        for (String token : tokens) {
            System.out.println(token);
        }


    }
}

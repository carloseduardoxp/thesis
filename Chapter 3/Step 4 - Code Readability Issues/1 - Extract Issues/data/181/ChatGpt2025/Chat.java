
public class Chat {

    public static void main(String[] args) {

        String textWithNewlines = "This is line one.\nThis is line two.\r\nThis is line three.";
        String textWithoutNewlines = textWithNewlines.replaceAll("\\r?\\n", "");
        System.out.println(textWithoutNewlines);

    }

}

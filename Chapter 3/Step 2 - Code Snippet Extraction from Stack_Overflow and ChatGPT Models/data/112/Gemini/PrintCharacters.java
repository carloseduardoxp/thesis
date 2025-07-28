public class PrintCharacters {
    public static void main(String[] args) {
        String str = "Hello Java!";

        System.out.println("Using charAt() in a for loop:");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println(ch);
        }
    }
}

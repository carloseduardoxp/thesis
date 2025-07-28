public class StringExample {
    public static void main(String[] args) {
        String str = "Hello, world!";
        StringBuilder sb = new StringBuilder(str);

        sb.reverse();
        String reversedStr = sb.toString();

        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + reversedStr);
    }
}

public class StringReverser {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        StringBuilder sb = new StringBuilder(originalString);
        String reversedString = sb.reverse().toString();
        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);
    }
}

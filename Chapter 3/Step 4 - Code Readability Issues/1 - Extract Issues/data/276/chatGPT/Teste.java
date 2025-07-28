
public class Teste {

    public static void main(String[] args) {
        String str = "Hello, world!";
        String substr = "world";
        int index = str.indexOf(substr);

        if (index != -1) {
            System.out.println("Substring found at index: " + index);
        } else {
            System.out.println("Substring not found");
        }

    }
}

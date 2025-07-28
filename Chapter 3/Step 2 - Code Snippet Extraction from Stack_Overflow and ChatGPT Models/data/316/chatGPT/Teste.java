
public class Teste {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = " + a); // Output: a = 10
        System.out.println("b = " + b); // Output: b = 5

    }
}

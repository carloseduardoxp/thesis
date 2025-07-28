
public class Teste {

    private void printStar(int n) {
        if (n > 0) {
            System.out.print("*");
            printStar(n - 1);
        }
    }
}

public class TowersOfHanoi {

    // Método recursivo para mover os discos
    public static void solve(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + source + " para " + destination);
            return;
        }
        solve(n - 1, source, auxiliary, destination);
        System.out.println("Mover disco " + n + " de " + source + " para " + destination);
        solve(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int n = 3; // número de discos
        solve(n, 'A', 'C', 'B'); // A: origem, C: destino, B: auxiliar
    }
}

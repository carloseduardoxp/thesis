public class TowersOfHanoi {

    // Método recursivo para mover os discos
    public static void solve(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + fromRod + " para " + toRod);
            return;
        }
        solve(n - 1, fromRod, auxRod, toRod);
        System.out.println("Mover disco " + n + " de " + fromRod + " para " + toRod);
        solve(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 3; // número de discos
        solve(n, 'A', 'C', 'B'); // A: origem, C: destino, B: auxiliar
    }
}

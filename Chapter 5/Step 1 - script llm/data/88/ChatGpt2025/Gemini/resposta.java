public class TowersOfHanoi {

    // Método recursivo para mover os discos
    public static void solve(int n, char fromRod, char auxRod, char toRod) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + fromRod + " para " + toRod);
            return;
        }
        solve(n - 1, fromRod, toRod, auxRod);
        System.out.println("Mover disco " + n + " de " + fromRod + " para " + toRod);
        solve(n - 1, auxRod, fromRod, toRod);
    }

    public static void main(String[] args) {
        int n = 3; // número de discos
        // A: origem, C: destino, B: auxiliar
        // A assinatura do método é solve(n, from, aux, to)
        solve(n, 'A', 'B', 'C');
    }
}

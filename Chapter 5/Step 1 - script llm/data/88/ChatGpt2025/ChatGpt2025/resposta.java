public class TowersOfHanoi {

    // Método recursivo para mover os discos
    public static void solve(int n, char sourceRod, char targetRod, char auxiliaryRod) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + sourceRod + " para " + targetRod);
            return;
        }
        solve(n - 1, sourceRod, auxiliaryRod, targetRod);
        System.out.println("Mover disco " + n + " de " + sourceRod + " para " + targetRod);
        solve(n - 1, auxiliaryRod, targetRod, sourceRod);
    }

    public static void main(String[] args) {
        int n = 3; // número de discos
        solve(n, 'A', 'C', 'B'); // A: origem, C: destino, B: auxiliar
    }
}
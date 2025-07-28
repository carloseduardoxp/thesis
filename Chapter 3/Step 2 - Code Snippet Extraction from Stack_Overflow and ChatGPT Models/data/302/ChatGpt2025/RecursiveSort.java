public class RecursiveSort {

    // Método recursivo para fazer bubble sort
    public static void recursiveBubbleSort(int[] arr, int n) {
        // Caso base: se o tamanho do array for 1, está ordenado
        if (n == 1) {
            return;
        }

        // Passa pelo array e troca elementos adjacentes se estiverem fora de ordem
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // troca arr[i] e arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Chamada recursiva para o array de tamanho n-1
        recursiveBubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array original:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        recursiveBubbleSort(arr, arr.length);

        System.out.println("\nArray ordenado:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

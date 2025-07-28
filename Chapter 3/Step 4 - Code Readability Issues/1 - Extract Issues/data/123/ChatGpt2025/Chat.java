
public class Chat {

    public static void main(String[] args) {

        int[] original = {1, 2, 3, 4, 5};
        int[] copia = new int[original.length];

        System.arraycopy(original, 0, copia, 0, original.length);

    }

}

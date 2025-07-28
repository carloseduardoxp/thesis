public class DeepSeek {

    public static void main(String[] args) {
        // Usage:
        int[] numbers = {1, 2, 3, 4, 5};
        numbers = popLastElement(numbers); // removes 5
        System.out.println(java.util.Arrays.toString(numbers));
    }

    public static int[] popLastElement(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        return newArray;
    }

}

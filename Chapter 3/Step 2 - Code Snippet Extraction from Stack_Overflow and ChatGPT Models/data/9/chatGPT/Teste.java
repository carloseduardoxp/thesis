public class Teste {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int index = 2; // index of element to be removed

        // create a new array with size one less than the original array
        int[] newArr = new int[arr.length - 1];

        // copy all elements before the element to be removed
        System.arraycopy(arr, 0, newArr, 0, index);

        // copy all elements after the element to be removed
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);

        // the element has been removed, newArr contains the new array



    }

}

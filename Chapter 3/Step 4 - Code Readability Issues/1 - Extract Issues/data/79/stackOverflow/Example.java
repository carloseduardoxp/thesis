
public class Example {

    private static int[] reverseArray(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) { // base condition, nothing to do when there is one or no element to consider
            return array;
        }
        // swap array[startIndex] and array[endIndex]
        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;
        // recurse with the decreasing bounds
        return reverseArray(array, startIndex + 1, endIndex - 1);
    }

}

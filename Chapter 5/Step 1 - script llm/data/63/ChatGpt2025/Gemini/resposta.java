import java.util.Arrays;

public class RemoveElement {
    private static final String ELEMENT_TO_REMOVE = "banana";

    public static void main(String[] args) {
        String[] array = {"apple", ELEMENT_TO_REMOVE, "cherry", ELEMENT_TO_REMOVE};
        String toRemove = ELEMENT_TO_REMOVE;

        // Remove only the first occurrence
        String[] result = removeElement(array, toRemove);

        System.out.println(Arrays.toString(result));
    }

    public static String[] removeElement(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                String[] newArray = new String[array.length - 1];
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i + 1, newArray, i, array.length - i - 1);
                return newArray;
            }
        }
        return array; // value not found, return original
    }
}

public class ReverseElement {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "cherry"};

        int indexToReverse = 1; // Let's reverse "banana"
        arr[indexToReverse] = new StringBuilder(arr[indexToReverse]).reverse().toString();

        // Print the updated array
        for (String s : arr) {
            System.out.println(s);
        }
    }
}

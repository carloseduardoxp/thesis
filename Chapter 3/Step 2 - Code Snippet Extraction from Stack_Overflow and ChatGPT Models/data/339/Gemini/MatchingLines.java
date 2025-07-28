
import java.util.ArrayList;
import java.util.List;

public class MatchingLines {

    public static List<String> findMatchingLinesNestedLoops(String[] arr1, String[] arr2) {
        List<String> matchingLines = new ArrayList<>();
        for (String line1 : arr1) {
            for (String line2 : arr2) {
                if (line1.equals(line2)) {
                    matchingLines.add(line1);
                    // If you only want to add each match once, regardless of duplicates in arr2,
                    // you might want to break the inner loop or use a Set for matchingLines
                    break; // Optimization: If a match is found for line1, move to the next line1
                }
            }
        }
        return matchingLines;
    }

    public static void main(String[] args) {
        String[] array1 = {"apple", "banana", "orange", "grape", "kiwi"};
        String[] array2 = {"banana", "grape", "melon", "apple", "peach"};

        List<String> matches = findMatchingLinesNestedLoops(array1, array2);
        System.out.println("Matching lines (Nested Loops): " + matches); // Output: [apple, banana, grape]
    }
}

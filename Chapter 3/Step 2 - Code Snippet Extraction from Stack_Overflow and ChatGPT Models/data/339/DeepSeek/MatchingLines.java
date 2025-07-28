
import java.util.ArrayList;
import java.util.List;

public class MatchingLines {
    public static void main(String[] args) {
        String[] array1 = {"apple", "banana", "orange", "grape"};
        String[] array2 = {"banana", "grape", "kiwi", "pear"};
        
        List<String> matches = findMatches(array1, array2);
        System.out.println("Matching lines: " + matches);
    }
    
    public static List<String> findMatches(String[] array1, String[] array2) {
        List<String> matches = new ArrayList<>();
        
        for (String line1 : array1) {
            for (String line2 : array2) {
                if (line1.equals(line2)) {
                    matches.add(line1);
                    break; // No need to check further for this line
                }
            }
        }
        
        return matches;
    }
}

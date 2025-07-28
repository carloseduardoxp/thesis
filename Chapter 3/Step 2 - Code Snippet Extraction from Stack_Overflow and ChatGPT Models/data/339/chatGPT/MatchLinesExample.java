import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchLinesExample {
    public static void main(String[] args) {
        String[] array1 = { "apple", "banana", "orange", "peach", "pear" };
        String[] array2 = { "orange", "pear", "grape", "pineapple" };

        List<String> matches = new ArrayList<>();

        for (String s : array1) {
            if (Arrays.asList(array2).contains(s)) {
                matches.add(s);
            }
        }

        System.out.println("Matching lines:");
        for (String s : matches) {
            System.out.println(s);
        }
    }
}

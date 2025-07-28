import java.util.*;

public class TopCharacters {
    public static void main(String[] args) {
        String text = "Example input text to test character frequency counting.";

        // Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Sort the map entries by value (frequency) in descending order
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(freqMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Display the top 5 characters
        System.out.println("Top 5 most frequent characters:");
        for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
            Map.Entry<Character, Integer> entry = sortedEntries.get(i);
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }
}

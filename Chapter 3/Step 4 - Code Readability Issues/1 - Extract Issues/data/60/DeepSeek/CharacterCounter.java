import java.util.*;
import java.util.stream.Collectors;

public class CharacterCounter {
    public static void main(String[] args) {
        String text = "This is a sample text for character counting demonstration.";
        System.out.println("Top 5 characters in the text:");
        System.out.println(getTopCharacters(text, 5));
    }

    public static List<Map.Entry<Character, Long>> getTopCharacters(String text, int topN) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }

        // Create a frequency map of characters
        Map<Character, Long> frequencyMap = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Sort the map by value in descending order
        List<Map.Entry<Character, Long>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Return top N entries
        return sortedEntries.stream()
                .limit(topN)
                .collect(Collectors.toList());
    }
}

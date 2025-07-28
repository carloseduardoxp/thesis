import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class CharacterCounter {

    public static Map<Character, Integer> countCharacters(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        return charCounts;
    }

    public static Map<Character, Integer> getTopNCharacters(Map<Character, Integer> charCounts, int n) {
        // Use a min-heap to keep track of the top N characters
        PriorityQueue<Map.Entry<Character, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (minHeap.size() < n) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // Convert the min-heap to a map with the top N characters
        Map<Character, Integer> topN = new HashMap<>();
        while (!minHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = minHeap.poll();
            topN.put(entry.getKey(), entry.getValue());
        }

        return topN;
    }

    public static void main(String[] args) {
        String text = "This is a sample text with several repeated characters.";
        Map<Character, Integer> allCounts = countCharacters(text);
        System.out.println("Character counts: " + allCounts);
        System.out.println("Total characters: " + text.length());

        int topN = 5;
        Map<Character, Integer> top5 = getTopNCharacters(allCounts, topN);
        System.out.println("\nTop " + topN + " characters:");
        // To display in descending order of count:
        top5.entrySet().stream()
            .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println("'" + entry.getKey() + "': " + entry.getValue()));
    }
}

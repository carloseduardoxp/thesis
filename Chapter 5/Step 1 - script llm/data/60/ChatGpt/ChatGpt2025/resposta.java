import java.util.*;

public class Example {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vitae ante a dolor dapibus convallis. Sed varius posuere sagittis. Vestibulum auctor, ipsum id ultrices lobortis, velit ipsum blandit nulla, eu cursus eros leo vitae erat. Duis sed ipsum at purus ullamcorper faucibus. Nullam in arcu ac ante ullamcorper pretium.";

        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                if (counts.containsKey(c)) {
                    counts.put(c, counts.get(c) + 1);
                } else {
                    counts.put(c, 1);
                }
            }
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(counts.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 characters:");
        for (int i = 0; i < 5 && i < entries.size(); i++) {
            Map.Entry<Character, Integer> entry = entries.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

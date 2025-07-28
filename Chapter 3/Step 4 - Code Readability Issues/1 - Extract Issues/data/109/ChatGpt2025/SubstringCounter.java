public class SubstringCounter {
    public static int countOccurrences(String str, String sub) {
        if (sub.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); // move past the last match
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "banana bandana banana";
        String word = "banana";

        int occurrences = countOccurrences(text, word);
        System.out.println("Occurrences: " + occurrences); // Output: 2
    }
}

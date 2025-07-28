public class CountOccurrences {
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int fromIndex = 0;
        
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            count++;
            fromIndex += sub.length(); // Move past the current found substring
        }
        
        return count;
    }

    public static void main(String[] args) {
        String text = "banana";
        String pattern = "an";
        
        int occurrences = countOccurrences(text, pattern);
        System.out.println("Occurrences of \"" + pattern + "\": " + occurrences);
    }
}

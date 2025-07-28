public class SubstringCounter {
    public static int countOccurrences(String text, String subString) {
        int count = 0;
        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = text.indexOf(subString, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += subString.length(); // Move past the found substring
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String text = "Java is great. Java is fun. Java is powerful.";
        String subString = "Java";
        int count = countOccurrences(text, subString);
        System.out.println("Number of occurrences of \"" + subString + "\": " + count); // Output: 3

        String text2 = "abababab";
        String subString2 = "ab";
        int count2 = countOccurrences(text2, subString2);
        System.out.println("Number of occurrences of \"" + subString2 + "\": " + count2); // Output: 4
    }
}

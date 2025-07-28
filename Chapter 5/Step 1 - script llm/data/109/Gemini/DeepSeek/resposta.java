public class StringCount {

    public static int countOccurrences(String text, String subString) {
        if (text == null || subString == null || subString.isEmpty()) {
            return 0; // Handle null or empty substring cases
        }

        int count = 0;
        int startIndex = 0;

        while (true) {
            int index = text.indexOf(subString, startIndex);
            if (index == -1) {
                break; // Substring not found
            }
            count++;
            startIndex = index + subString.length();
        }
        return count;
    }

    public static void main(String[] args) {
        String mainString = "This is a test string. This string contains the word string multiple times.";
        String searchString = "string";
        int occurrences = countOccurrences(mainString, searchString);
        System.out.println("The string \"" + searchString + "\" appears " + occurrences + " times.");

        String anotherString = "aaaaa";
        String searchA = "aa";
        int occurrencesA = countOccurrences(anotherString, searchA);
        System.out.println("The string \"" + searchA + "\" appears " + occurrencesA + " times.");
    }
}

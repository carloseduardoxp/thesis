public class StringPosition {
    public static void main(String[] args) {
        String mainString = "This is a sample string.";
        String subString = "sample";

        int index = mainString.indexOf(subString);

        if (index != -1) {
            System.out.println("'" + subString + "' found at index: " + index);
        } else {
            System.out.println("'" + subString + "' not found in the string.");
        }

        String notFoundString = "Java";
        int notFoundIndex = mainString.indexOf(notFoundString);
        System.out.println("'" + notFoundString + "' found at index: " + notFoundIndex); // Output: -1
    }
}

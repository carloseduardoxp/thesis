public class RemoveNewlines {
    public static void main(String[] args) {
        String textWithNewlines = "This is a line 1.\n" +
                                  "This is line 2.\r\n" +
                                  "This is line 3.";

        // Method 1: Using replaceAll() with a regex for all newline types
        String noNewlinesRegex = textWithNewlines.replaceAll("[\\n\\r]", "");
        System.out.println("Using replaceAll with regex: " + noNewlinesRegex);

        // Method 2: Using replace() for specific newlines (if you know them)
        String noNewlinesN = textWithNewlines.replace("\n", "");
        String noNewlinesR = noNewlinesN.replace("\r", "");
        System.out.println("Using replace for \\n and \\r: " + noNewlinesR);

        // Or combine them for cleaner code
        String noNewlinesCombined = textWithNewlines.replace("\n", "").replace("\r", "");
        System.out.println("Using combined replace: " + noNewlinesCombined);
    }
}

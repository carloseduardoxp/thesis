public class Chat {
    // ANSI escape codes for colors
    public static final String RESET = "\033[0m";  // Reset color
    public static final String RED = "\033[0;31m";  // Red color
    public static final String GREEN = "\033[0;32m";  // Green color
    public static final String YELLOW = "\033[0;33m";  // Yellow color
    public static final String BLUE = "\033[0;34m";  // Blue color

    public static void main(String[] args) {
        System.out.println(RED + "This is red text" + RESET);
        System.out.println(GREEN + "This is green text" + RESET);
        System.out.println(YELLOW + "This is yellow text" + RESET);
        System.out.println(BLUE + "This is blue text" + RESET);
    }
}

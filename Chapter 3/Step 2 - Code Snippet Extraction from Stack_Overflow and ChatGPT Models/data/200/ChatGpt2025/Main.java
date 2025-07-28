public class Main {
    public static void main(String[] args) {
        String input = "123"; // Change this to test different inputs

        if (isInteger(input)) {
            System.out.println("Input is a valid integer.");
        } else {
            System.out.println("Input is NOT a valid integer.");
        }
    }

    public static boolean isInteger(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

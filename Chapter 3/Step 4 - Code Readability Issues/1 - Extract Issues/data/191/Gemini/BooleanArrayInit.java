public class BooleanArrayInit {
    public static void main(String[] args) {
        // Declare and initialize a boolean array of size 5
        boolean[] flags = new boolean[5];

        // Print the elements to demonstrate default initialization
        for (int i = 0; i < flags.length; i++) {
            System.out.println("flags[" + i + "]: " + flags[i]);
        }
        // Output will be:
        // flags[0]: false
        // flags[1]: false
        // flags[2]: false
        // flags[3]: false
        // flags[4]: false
    }
}

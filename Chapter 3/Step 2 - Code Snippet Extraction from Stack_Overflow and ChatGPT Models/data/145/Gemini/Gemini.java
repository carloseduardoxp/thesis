public class CommandLineOutput {
    public static void main(String[] args) {
        // Using System.out.println()
        System.out.println("Hello, this is the first line of output.");
        System.out.println("This is the second line.");

        // Using System.out.print()
        System.out.print("This will be on the same line as the next output.");
        System.out.print(" This is indeed on the same line.\n"); // \n for a new line manually

        // Combining
        String name = "Alice";
        int age = 30;
        System.out.println("Name: " + name + ", Age: " + age);

        // Printing numbers
        System.out.println(123);
        System.out.println(45.67);

        // Using printf for formatted output (more advanced, like C's printf)
        System.out.printf("The value of PI is approximately %.2f%n", Math.PI); // %n for new line
    }
}

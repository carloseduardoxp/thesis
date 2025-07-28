public class FizzBuzz {

    public static void main(String[] args) {
        int limit = 100; // You can change this limit

        for (int i = 1; i <= limit; i++) {
            if (i % 15 == 0) { // Check for divisibility by 15 first (both 3 and 5)
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) { // Check for divisibility by 3
                System.out.println("Fizz");
            } else if (i % 5 == 0) { // Check for divisibility by 5
                System.out.println("Buzz");
            } else { // If none of the above, print the number
                System.out.println(i);
            }
        }
    }
}

public class LargestProduct {

    public static void main(String[] args) {
        long largestProduct = 0;
        int num1 = 0;
        int num2 = 0;

        // Iterate through all possible pairs of numbers less than 1000
        // We start from 999 and go down to 1 to find the largest product faster
        for (int i = 999; i >= 1; i--) {
            for (int j = 999; j >= 1; j--) {
                long product = (long) i * j; // Cast to long to avoid overflow

                if (product > largestProduct) {
                    largestProduct = product;
                    num1 = i;
                    num2 = j;
                }
            }
        }

        System.out.println("The largest product of two numbers less than 1000 is: " + largestProduct);
        System.out.println("The numbers are: " + num1 + " and " + num2);
    }
}

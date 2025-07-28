
public class Gemini {

    public static void main(String[] args) {
        int numerator = 5;
        int denominator = 2;

        double result1 = (double) numerator / denominator; // Cast numerator to double
        System.out.println(result1); // Output: 2.5

        double result2 = numerator / (double) denominator; // Cast denominator to double
        System.out.println(result2); // Output: 2.5

// Or simply make one of them a double literal
        double result3 = 5.0 / 2;
        System.out.println(result3); // Output: 2.5

    }

}

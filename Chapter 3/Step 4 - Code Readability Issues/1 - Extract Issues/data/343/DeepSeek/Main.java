
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal num = new BigDecimal("100.50");
        BigDecimal decrementValue = new BigDecimal("10.25");

        // Subtract a value
        num = num.subtract(decrementValue);
        System.out.println("After subtraction: " + num); // 90.25

        // Subtract 1 (common use case)
        num = num.subtract(BigDecimal.ONE);
        System.out.println("After subtracting 1: " + num); // 89.25
    }
}

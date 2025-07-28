
import java.math.BigDecimal;

public class DeclineBigDecimal {
    public static void main(String[] args) {
        BigDecimal positiveValue = new BigDecimal("123.45");
        System.out.println("Original positive value: " + positiveValue);

        BigDecimal negativeValue = positiveValue.negate();
        System.out.println("Negated value: " + negativeValue);

        BigDecimal anotherPositive = new BigDecimal("50");
        BigDecimal anotherNegative = anotherPositive.negate();
        System.out.println("Another negated value: " + anotherNegative);

        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal negatedZero = zero.negate();
        System.out.println("Negated zero: " + negatedZero); // Still zero
    }
}

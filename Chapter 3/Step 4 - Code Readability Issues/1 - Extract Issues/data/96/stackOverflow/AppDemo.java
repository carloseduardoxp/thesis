import java.math.BigInteger;

public class AppDemo {

    public static void main(String[] args) {

        BigInteger a = new BigInteger("9223372036854775807");
        BigInteger b = new BigInteger("9223372036854775808");
        BigInteger result = a.add(b);
    }
}
import java.math.BigInteger;

public class AppDemo {

    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(9223372036854775807L);
        BigInteger b = new BigInteger("9223372036854775808");
        a.add(b);
    }
}
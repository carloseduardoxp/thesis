public class TimeSinceEpoch {
    public static void main(String[] args) {
        long millisecondsSinceEpoch = System.currentTimeMillis();
        System.out.println("Milliseconds since epoch: " + millisecondsSinceEpoch);

        // If you need it in seconds, you can divide by 1000
        long secondsSinceEpoch = millisecondsSinceEpoch / 1000;
        System.out.println("Seconds since epoch: " + secondsSinceEpoch);
    }
}

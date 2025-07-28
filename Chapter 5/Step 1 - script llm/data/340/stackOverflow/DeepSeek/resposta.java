public class RandomTest {

    public static void main(String[] args) {
        int xSpeed;
        int ySpeed;

        if (Math.random() >= 0.5) {
            xSpeed = -10;
        } else {
            xSpeed = 10;
        }

        if (Math.random() >= 0.5) {
            ySpeed = -10;
        } else {
            ySpeed = 10;
        }
    }
}
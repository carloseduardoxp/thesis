import java.util.Random;

public class ChooseNumberExample {
    public static void main(String[] args) {
        Random rand = new Random();
        int num1 = 5;
        int num2 = 10;
        int result = rand.nextBoolean() ? num1 : num2;
        System.out.println("Randomly chosen number: " + result);
    }
}

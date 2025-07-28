
import java.util.Random;

public class RandomChoice {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        
        Random random = new Random();
        int chosen = random.nextBoolean() ? num1 : num2;
        
        System.out.println("Randomly chosen: " + chosen);
    }
}

import java.util.Random;

public class Teste {

    public static void main(String[] args) {        
        int min = 1;
        int max = 49;
        
        Random random = new Random();
         int randomnumber=random.nextInt(max - min) + min;
    }
}

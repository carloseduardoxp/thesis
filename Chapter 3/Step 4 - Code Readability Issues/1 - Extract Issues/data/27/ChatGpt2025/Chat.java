import java.util.Arrays;

public class Chat {
    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3};
        int[] newArray = Arrays.copyOf(oldArray, 5); // New size is 5

        newArray[3] = 4;
        newArray[4] = 5;
    }
}


import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {

        Arrays.sort(myArray, new Comparator<MyObject>() {
            @Override
            public int compare(MyObject o1, MyObject o2) {
                return o1.getMyKey().compareTo(o2.getMyKey());
            }
        });

        Arrays.sort(myArray, (o1, o2) -> o1.getMyKey().compareTo(o2.getMyKey()));

    }
}

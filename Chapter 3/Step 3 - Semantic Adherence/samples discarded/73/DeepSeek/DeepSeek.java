
import java.util.ArrayList;
import java.util.Arrays;

public class DeepSeek {

    public static int[] removeElementWithList(int[] arr, int index) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        arrayList.remove(index);
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}

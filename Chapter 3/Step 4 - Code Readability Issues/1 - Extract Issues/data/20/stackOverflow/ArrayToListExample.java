import java.util.List;

public class ArrayToListExample {

    public static double[] integersToDoubles(List<Integer> integers) {
        double[] ret = new double[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).doubleValue();
        }
        return ret;
    }
}

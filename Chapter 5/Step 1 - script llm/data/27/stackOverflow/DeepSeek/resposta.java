import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        char[] copyFrom = {'a', 'b', 'c', 'd', 'e'};
        char[] copyTo = new char[7];

        System.out.println(Arrays.toString(copyFrom));
        System.arraycopy(copyFrom, 0, copyTo, 0, copyFrom.length);
        System.out.println(Arrays.toString(copyTo));

        String[] array = expand(new String[5], 10);
    }

    private static String[] expand(String[] array, int size) {
        String[] temp = new String[size];
        System.arraycopy(array, 0, temp, 0, array.length);
        for (int j = array.length; j < size; j++) {
            temp[j] = "";
        }
        return temp;
    }

}
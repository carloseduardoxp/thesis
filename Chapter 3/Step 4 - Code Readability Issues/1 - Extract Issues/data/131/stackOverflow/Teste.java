public class Teste {

    public static void main(String[] args) {        
        final String[] strings = {"1", "2"};
        final int[] ints = new int[strings.length];
        for (int i=0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
    }
}
public class Gemini {

    public static void main(String[] args) {

        int[] original = {1, 2, 3, 4, 5};
        int[] copied = new int[original.length]; // Must create a new array first

        System.arraycopy(original, 0, copied, 0, original.length);
    }
}

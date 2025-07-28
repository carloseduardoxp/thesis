public class MatchLines {
    public static void main(String[] args) {
        String[] array1 = {"apple", "banana", "cherry", "date"};
        String[] array2 = {"banana", "date", "fig", "grape"};

        System.out.println("Matching lines:");
        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s1.equals(s2)) {
                    System.out.println(s1);
                }
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        boolean palindromeFound = false;

        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int k = i * j;
                int m = 0;
                int n = k;

                while (n > 0) {
                    int l = n % 10;
                    m = m * 10 + l;
                    n = n / 10;
                }

                if (m == k) {
                    System.out.println("pal " + k + " of " + i + " and " + j);
                    palindromeFound = true;
                    break;
                }
            }

            if (palindromeFound) {
                break;
            }
        }
    }
}

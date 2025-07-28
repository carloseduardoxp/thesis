public class AsciiArtExample {
    public static void main(String[] args) {
        int size = 10;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == 0 && j % 2 == 1) || (i == 1 && j % 2 == 0) ||
                    (i - j == 2) || (i + j == size + 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

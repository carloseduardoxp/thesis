public class Teste {

    public static void main(String[] args) {

        int[][] board = {{1, 0, 2}, {0, 1, 0}, {0, 2, 0}};

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                printCell(board[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
        }
        System.out.println("\n--------------------------------------------");
    }

    public static void printCell(int content) {
        switch (content) {
            case 0:
                System.out.print("\t \t");
                break;
            case 1:
                System.out.print("\tX\t");
                break;
            case 2:
                System.out.print("\tO\t");
                break;
            default:
                System.out.print("\t?\t");
                break;
        }
    }
}
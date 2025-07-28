import java.util.Scanner;
import java.util.Stack;

public class TowersOfHanoiPrint {
    public static int numDisks;
    @SuppressWarnings("unchecked")
    public static final Stack<Integer>[] towers = new Stack[4];

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            towers[1] = new Stack<>();
            towers[2] = new Stack<>();
            towers[3] = new Stack<>();
            System.out.print("Enter number of disks: ");
            int num = input.nextInt();
            numDisks = num;
            System.out.println("Number of moves: " + stackMove(num));
        }
    }

    public static int stackMove(int n) {
        for (int d = n; d > 0; d--)
            towers[1].push(d);
        printTowers();
        return move(n, 1, 2, 3);
    }

    public static int move(int n, int fromPeg, int auxPeg, int toPeg) {
        if (n > 0) {
            int numberMovesA = move(n - 1, fromPeg, toPeg, auxPeg);
            int d = towers[fromPeg].pop();
            towers[toPeg].push(d);
            printTowers();
            int numberMovesB = move(n - 1, auxPeg, fromPeg, toPeg);
            return (numberMovesA + numberMovesB + 1);
        }
        return 0;
    }

    public static void printTowers() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = numDisks - 1; i >= 0; i--) {
            String d1 = " ";
            String d2 = " ";
            String d3 = " ";
            if (i < towers[1].size()) {
                d1 = String.valueOf(towers[1].get(i));
            }
            if (i < towers[2].size()) {
                d2 = String.valueOf(towers[2].get(i));
            }
            if (i < towers[3].size()) {
                d3 = String.valueOf(towers[3].get(i));
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.print("\n");
    }
}

import java.util.Stack;
import java.util.Scanner;

public class TowersOfHanoiPrint {
    private static final int maxDisks;
    private static final Stack<Integer>[] towers = new Stack[4];

    static {
        maxDisks = 0; // Will be initialized in main
        towers[1] = new Stack<>();
        towers[2] = new Stack<>();
        towers[3] = new Stack<>();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int numDisks = input.nextInt();
        maxDisks = numDisks;
        System.out.println("Number of moves: " + calculateMoves(numDisks));
    }

    public static int calculateMoves(int numberOfDisks) {
        for (int disk = numberOfDisks; disk > 0; disk--) {
            towers[1].push(disk);
        }
        printTowers();
        return moveDisks(numberOfDisks, 1, 2, 3);
    }

    public static int moveDisks(int disksToMove, int source, int auxiliary, int target) {
        if (disksToMove > 0) {
            int movesA = moveDisks(disksToMove - 1, source, target, auxiliary);
            int disk = towers[source].pop();
            towers[target].push(disk);
            printTowers();
            int movesB = moveDisks(disksToMove - 1, auxiliary, source, target);
            return (movesA + movesB + 1);
        }
        return 0;
    }

    public static void printTowers() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = maxDisks - 1; i >= 0; i--) {
            String diskA = " ";
            String diskB = " ";
            String diskC = " ";
            
            if (i < towers[1].size()) {
                diskA = String.valueOf(towers[1].get(i));
            }
            if (i < towers[2].size()) {
                diskB = String.valueOf(towers[2].get(i));
            }
            if (i < towers[3].size()) {
                diskC = String.valueOf(towers[3].get(i));
            }
            System.out.println("  " + diskA + "  |  " + diskB + "  |  " + diskC);
        }
        System.out.print("\n");
    }
}

import java.util.Scanner;
import java.util.Stack;

public class TowersOfHanoiPrint {
    private static int numDisks;
    private static final Stack<Integer>[] pegs = new Stack[4];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        pegs[1] = new Stack<>();
        pegs[2] = new Stack<>();
        pegs[3] = new Stack<>();
        System.out.print("Enter 5 integers: ");
        int diskCount = input.nextInt();
        numDisks = diskCount;
        System.out.println("Number of moves: " + stackMove(diskCount));
    }

    public static int stackMove(int diskCount) {
        for (int disk = diskCount; disk > 0; disk--) {
            pegs[1].push(disk);
        }
        printStack();
        return move(diskCount, 1, 2, 3);
    }

    public static int move(int diskCount, int fromPeg, int auxPeg, int toPeg) {
        if (diskCount > 0) {
            int movesA = move(diskCount - 1, fromPeg, toPeg, auxPeg);
            int disk = pegs[fromPeg].pop();
            pegs[toPeg].push(disk);
            printStack();
            int movesB = move(diskCount - 1, auxPeg, fromPeg, toPeg);
            return (movesA + movesB + 1);
        }
        return 0;
    }

    public static void printStack() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = numDisks - 1; i >= 0; i--) {
            String pegA = " ";
            String pegB = " ";
            String pegC = " ";
            try {
                pegA = String.valueOf(pegs[1].get(i));
            } catch (Exception ignored) {
            }
            try {
                pegB = String.valueOf(pegs[2].get(i));
            } catch (Exception ignored) {
            }
            try {
                pegC = String.valueOf(pegs[3].get(i));
            } catch (Exception ignored) {
            }
            System.out.println("  " + pegA + "  |  " + pegB + "  |  " + pegC);
        }
        System.out.print("\n");
    }
}

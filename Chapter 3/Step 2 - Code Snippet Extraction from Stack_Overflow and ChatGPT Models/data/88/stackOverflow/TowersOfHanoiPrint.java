import java.util.Stack;

import java.util.*;

public class TowersOfHanoiPrint {
    public static int N;
    public static Stack<Integer>[] integer = new Stack[4];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        integer[1] = new Stack<>();
        integer[2] = new Stack<>();
        integer[3] = new Stack<>();
        System.out.print("Enter 5 integers: ");
        int num = input.nextInt();
        N = num;
        System.out.println("Number of moves: "+StackMove(num));
    }

    public static int StackMove(int N) {
        for (int d = N; d > 0; d--)
            integer[1].push(d);
        PrintStack();
        return move(N, 1, 2, 3);
    }

    public static int move(int N, int a, int b, int c) {
        if (N > 0) {
            int numberMovesA = move(N - 1, a, c, b);
            int d = integer[a].pop();
            integer[c].push(d);
            PrintStack();
            int numberMovesB = move(N - 1, b, a, c);
            return (numberMovesA + numberMovesB + 1);
        }
        return 0;
    }

    public static void PrintStack() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = N - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(integer[1].get(i));
            } catch (Exception e) {
            }
            try {
                d2 = String.valueOf(integer[2].get(i));
            } catch (Exception e) {
            }
            try {
                d3 = String.valueOf(integer[3].get(i));
            } catch (Exception e) {
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.print("\n");
    }
}
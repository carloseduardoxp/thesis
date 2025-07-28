import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Gemini {

    static final String BOARD_SEPARATOR = "-------------";

    static char[] board;
    static char playerMarker;
    static char computerMarker;
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        board = new char[9];
        scanner = new Scanner(System.in);
        random = new Random();

        initializeBoard();
        chooseMarkers();
        playGame();

        scanner.close();
    }

    static void initializeBoard() {
        Arrays.fill(board, ' ');
    }

    static void chooseMarkers() {
        System.out.print("Do you want to be X or O? ");
        playerMarker = scanner.next().toUpperCase().charAt(0);
        computerMarker = (playerMarker == 'X') ? 'O' : 'X';
        System.out.println("You are " + playerMarker + ". The computer is " + computerMarker + ".");
    }

    static void displayBoard() {
        System.out.println(BOARD_SEPARATOR);
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println(BOARD_SEPARATOR);
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println(BOARD_SEPARATOR);
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println(BOARD_SEPARATOR);
    }

    static boolean isBoardFull() {
        for (char c : board) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }

    static boolean checkWin(char marker) {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == marker && board[i + 1] == marker && board[i + 2] == marker) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] == marker && board[i + 3] == marker && board[i + 6] == marker) {
                return true;
            }
        }
        // Check diagonals
        return (board[0] == marker && board[4] == marker && board[8] == marker) ||
               (board[2] == marker && board[4] == marker && board[6] == marker);
    }

    static void placeMove(int position, char marker) {
        if (position >= 1 && position <= 9 && board[position - 1] == ' ') {
            board[position - 1] = marker;
        } else {
            System.out.println("Invalid move!");
        }
    }

    static int getPlayerMove() {
        int move;
        do {
            System.out.print("Enter your move (1-9): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.next(); // consume the invalid input
            }
            move = scanner.nextInt();
        } while (move < 1 || move > 9 || board[move - 1] != ' ');
        return move;
    }

    static int getComputerMove() {
        // Basic random move for now
        int move;
        do {
            move = random.nextInt(9) + 1;
        } while (board[move - 1] != ' ');
        System.out.println("Computer plays at position " + move);
        return move;
    }

    static void playGame() {
        boolean gameWon = false;
        char currentPlayer = playerMarker;

        System.out.println("Let's play Tic-Tac-Toe!");
        displayBoard();

        while (!gameWon && !isBoardFull()) {
            if (currentPlayer == playerMarker) {
                int playerMove = getPlayerMove();
                placeMove(playerMove, playerMarker);
            } else {
                int computerMove = getComputerMove();
                placeMove(computerMove, computerMarker);
            }

            displayBoard();

            if (checkWin(currentPlayer)) {
                gameWon = true;
                if (currentPlayer == playerMarker) {
                    System.out.println("You win!");
                } else {
                    System.out.println("Computer wins!");
                }
            }

            currentPlayer = (currentPlayer == playerMarker) ? computerMarker : playerMarker;
        }

        if (!gameWon && isBoardFull()) {
            System.out.println("It's a draw!");
        }
    }
}

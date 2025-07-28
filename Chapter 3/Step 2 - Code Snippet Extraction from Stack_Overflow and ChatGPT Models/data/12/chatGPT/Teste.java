
import java.util.Scanner;

public class Teste {

    private char[][] board;
    private char currentPlayer;

    public Teste() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.println("Tic Tac Toe Game");
        System.out.println("Player 1: X, Player 2: O");

        while (!isGameOver()) {
            printBoard();
            System.out.println(currentPlayer + "'s turn");

            // Get row and column input from player
            System.out.print("Enter row (1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        printBoard();

        // Determine the winner
        char winner = getWinner();
        if (winner == 'X' || winner == 'O') {
            System.out.println(winner + " wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false; // Out of bounds
        }
        return board[row][col] == '-';
    }

    private boolean isGameOver() {
        return isBoardFull() || getWinner() != '-';
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private char getWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

    }

}

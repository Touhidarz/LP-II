import java.util.*;

public class Nqueen {
    public static boolean isSafe(char board[][], int row, int col) {
        // vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }

        }

        // diagonaly left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;

            }

        }

        // vertical right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // base case

        if (row == board.length) {

            print(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j) == true) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static int count = 0;

    public static void print(char board[][]) {
        System.out.println("-----------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows :");
        n = sc.nextInt();
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
        System.out.println("total Solutions =" + count);

    }
}

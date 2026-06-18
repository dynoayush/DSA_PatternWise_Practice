// N-Queens [LC-51]

import java.util.*;

public class Q69 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allBoards = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, allBoards, 0);

        return allBoards;
    }

    private boolean isSafe(int row, int col, char[][] board) {

        // Left
        for (int c = col; c >= 0; c--) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }

        // Upper Left Diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Left Diagonal
        for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void saveBoard(char[][] board,
                           List<List<String>> allBoards) {

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            String row = "";

            for (int j = 0; j < board.length; j++) {
                row += board[i][j];
            }

            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    private void helper(char[][] board,
                        List<List<String>> allBoards,
                        int col) {

        // All queens placed
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int row = 0; row < board.length; row++) {

            if (isSafe(row, col, board)) {

                // Place Queen
                board[row][col] = 'Q';

                // Explore
                helper(board, allBoards, col + 1);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {

        Q69 obj = new Q69();

        List<List<String>> result = obj.solveNQueens(4);

        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}


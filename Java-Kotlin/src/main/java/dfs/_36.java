package dfs;

public class _36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                char currChar = board[row][col];
                if (currChar != '.') {
                    for (int i = 0; i < 9; i++) {
                        if (board[i][col] != '.' && board[i][col] == currChar && i != row) {
                            return false;
                        }
                        if (board[row][i] != '.' && board[row][i] == currChar && i != col) {
                            return false;
                        }
                        int p = 3 * (row / 3) + i / 3;
                        int q = 3 * (col / 3) + i % 3;
                        if (board[p][q] != '.' && board[p][q] == currChar && p != row && q != col) {
                            return false;
                        }
                    }

                }
            }
        }

        return true;
    }
}

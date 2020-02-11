package dfs;

public class _37 {

    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if the current char is not a number yet, then we need to do something
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            int p = 3 * (row / 3) + i / 3;
            int q = 3 * (col / 3) + i % 3;
            if (board[p][q] != '.' && board[p][q] == c) {
                return false;
            }
        }
        return true;
    }
}

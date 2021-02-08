package nowcoder;

// the blue book
public class nc47 {

    private static boolean isValid(char[][] board) {
        return board != null && board.length != 0 && board[0].length != 0;
    }

    private static boolean dfs(char[][] board, int i, int j, int m, int n) {
        if (j == n) {
            return dfs(board, i + 1, 0, m, n);
        }

        if (i == m) {
            return true;
        }

        if (board[i][j] != '.') {
            return dfs(board, i, j + 1, m, n);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            if (dfs(board, i, j + 1, m, n)) {
                return true;
            }

            board[i][j] = '.';
        }

        return false;
    }

    private static boolean isValid(char[][] board, int i, int j, char ch) {
        for (int idx = 0; idx < 9; idx++) {
            if (board[idx][j] == ch) {
                return false;
            }
            if (board[i][idx] == ch) {
                return false;
            }
            if (board[(i / 3) * 3 + idx / 3][(j / 3) * 3 + idx % 3] == ch) {
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (!isValid(board)) {
            return;
        }
        dfs(board, 0, 0, board.length, board[0].length);
    }
}

package dfs;

public class _79 {

    //记录某个位置是否已经搜索过
    boolean[][] visited;
    int x, y;
    //四个方向
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        x = board.length;
        y = board[0].length;
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                //尝试从每一个点出发进行搜索，如果搜索到了就表明存在这个单词，直接返回true
                if (process(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, int row, int col, String word, int index) {
        //递归的第一步，列出终止条件，避免进入死循环。
        if (index == word.length() - 1) {
            return board[row][col] == word.charAt(index);
        }
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            //分别从四个方向进行搜索
            for (int i = 0; i < 4; i++) {
                int newRow = row + d[i][0];
                int newCol = col + d[i][1];
                //能够递归需满足位置未越界并且未被访问这样的条件
                if (legal(newRow, newCol) && !visited[newRow][newCol] && process(board, newRow, newCol, word, index + 1)) {
                    return true;
                }
            }
            //搜索完以后需要回溯
            visited[row][col] = false;
        }
        return false;
    }

    //判断位置是否越界
    private boolean legal(int row, int col) {
        return row >= 0 && row < x && col >= 0 && col < y;
    }
}



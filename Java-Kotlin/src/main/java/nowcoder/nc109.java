package nowcoder;

// https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
public class nc109 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solve(char[][] grid) {
        // write code here
        if (!isValid(grid)) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(visited, grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(boolean[][] visited, char[][] grid, int i, int j, int m, int n) {
        visited[i][j] = true;
        for (int k = 0; k < DIRECTIONS.length; k++) {
            int newX = i + DIRECTIONS[k][0];
            int newY = j + DIRECTIONS[k][1];
            if (inArea(newX, newY, m, n) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(visited, grid, newX, newY, m, n);
            }
        }
    }

    private static boolean inArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private static boolean isValid(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        return true;
    }
}

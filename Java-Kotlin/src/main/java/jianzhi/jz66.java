package jianzhi;

public class jz66 {

    private static int dfs(int row, int col, int rows, int cols, int threshold, boolean[][] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row][col]
                && isThresholdOK(row, col, threshold)) {
            visited[row][col] = true;
            count = 1 + dfs(row - 1, col, rows, cols, threshold, visited)
                    + dfs(row + 1, col, rows, cols, threshold, visited)
                    + dfs(row, col - 1, rows, cols, threshold, visited)
                    + dfs(row, col + 1, rows, cols, threshold, visited);

        }
        return count;
    }

    private static boolean isThresholdOK(int row, int col, int threshold) {
        return getIndexSum(row) + getIndexSum(col) <= threshold;
    }

    private static int getIndexSum(int index) {
        int sum = 0;
        while (index != 0) {
            int digit = index % 10;
            sum += digit;
            index /= 10;
        }
        return sum;
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];
        return dfs(0, 0, rows, cols, threshold, visited);
    }
}

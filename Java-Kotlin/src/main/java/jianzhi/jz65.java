package jianzhi;

public class jz65 {

    private static boolean dfs(char[] matrix, int row, int col, int rows, int cols, char[] str,
                               int pathLength, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength] &&
                !visited[row * cols + col]) {
            visited[row * cols + col] = true;

            hasPath = dfs(matrix, row - 1, col, rows, cols, str, pathLength + 1, visited)
                    || dfs(matrix, row + 1, col, rows, cols, str, pathLength + 1, visited)
                    || dfs(matrix, row, col - 1, rows, cols, str, pathLength + 1, visited)
                    || dfs(matrix, row, col + 1, rows, cols, str, pathLength + 1, visited);

            if (!hasPath) {
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || rows == 0 || cols == 0 || str == null || str.length == 0) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(matrix, row, col, rows, cols, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

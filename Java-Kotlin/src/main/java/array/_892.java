package array;

public class _892 {

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int area = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 0) {
                    area += 2;
                    area += checkLeft(grid, row, col, i, j);
                    area += checkUp(grid, row, col, i, j);
                    area += checkRight(grid, row, col, i, j);
                    area += checkDown(grid, row, col, i, j);
                    System.out.println("finish process i: " + i + " j: " + j + " " + grid[i][j] + " area: " + area);
                }

            }
        }
        System.out.println(area);
        return area;
    }

    private static int checkDown(int[][] grid, int row, int col, int i, int j) {
        if (i < row - 1) {
            int downNeighbor = grid[i + 1][j];
            if (downNeighbor > 0) {
                if (downNeighbor > grid[i][j]) {
                    return 0;
                } else {
                    return grid[i][j] - downNeighbor;
                }
            } else {
                return grid[i][j];
            }

        } else {
            return grid[i][j];
        }
    }

    private static int checkRight(int[][] grid, int row, int col, int i, int j) {
        if (j < col - 1) {
            int rightNeighbor = grid[i][j + 1];
            if (rightNeighbor > 0) {
                if (rightNeighbor > grid[i][j]) {
                    return 0;
                } else {
                    return grid[i][j] - rightNeighbor;
                }
            } else {
                return grid[i][j];
            }

        } else {
            return grid[i][j];
        }
    }

    private static int checkUp(int[][] grid, int row, int col, int i, int j) {
        if (i > 0) {
            int upNeighbor = grid[i - 1][j];
            if (upNeighbor > 0) {
                if (upNeighbor > grid[i][j]) {
                    return 0;
                } else {
                    return grid[i][j] - upNeighbor;
                }
            } else {
                return grid[i][j];
            }
        } else {
            return grid[i][j];
        }
    }

    private static int checkLeft(int[][] grid, int row, int col, int i, int j) {
        if (j > 0) {
            int leftNeighbor = grid[i][j - 1];
            if (leftNeighbor > 0) {
                if (leftNeighbor > grid[i][j]) {
                    return 0;
                } else {
                    return grid[i][j] - leftNeighbor;
                }
            } else {
                return grid[i][j];
            }
        } else {
            return grid[i][j];
        }
    }

    public static void main(String[] args) {
        new _892().surfaceArea(new int[][]{{1, 0}, {0, 2}});
    }
}

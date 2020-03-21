package array;

public class _59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0){
            return matrix;
        }
        int num = 1;
        int startX = 0;
        int startY = 0;
        int endX = n-1;
        int endY = n-1;
        int tar = n*n;
        while (num <= tar){
            for (int i = startY; i <= endY ; i++) {
                matrix[startX][i] = num++;

            }
            startX++;
            for (int i = startX; i <= endX ; i++) {
                matrix[i][endY] = num++;
            }
            endY--;

            for (int i = endY; i >= startY ; i--) {
                matrix[endX][i] = num++;

            }
            endX--;
            for (int i = endX; i >= startX ; i--) {
                matrix[i][startY] = num++;

            }
            startY++;
        }
        return matrix;

    }
}

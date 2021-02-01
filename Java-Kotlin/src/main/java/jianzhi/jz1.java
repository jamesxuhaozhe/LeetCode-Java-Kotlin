package jianzhi;

public class jz1 {

    public boolean Find(int target, int[][] array) {
        if (!isValid(array)) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        return true;
    }
}

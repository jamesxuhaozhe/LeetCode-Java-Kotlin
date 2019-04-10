package Array;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }

}

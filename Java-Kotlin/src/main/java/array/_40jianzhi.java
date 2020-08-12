package array;

import java.util.Arrays;

public class _40jianzhi {

    // stupid version TODO use a heap
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}

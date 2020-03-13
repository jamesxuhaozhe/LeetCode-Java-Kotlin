package array._832;

/**
 * Problem link: https://leetcode-cn.com/problems/flipping-an-image/
 *
 * Time complexity: TODO
 *
 * Space complexity: TODO
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        int outerSize = A.length;
        for (int[] currentArray : A) {
            processArray(currentArray);
        }
        return A;
    }

    private void processArray(int[] array) {
        if (array.length == 0) {
            return;
        }

        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int middle = array[j];
            array[j] = array[i];
            array[i] = middle;
            i++;
            j--;
        }
        for (int m = 0; m < array.length; m++) {
            array[m] = reverseInt(array[m]);
        }
    }

    private int reverseInt(int i) {
        if (i == 0) {
            return 1;
        }

        return 0;
    }
}

package array;

import java.util.Arrays;

/**
 * Problem link: https://leetcode-cn.com/problems/how-many-apples-can-you-put-into-the-basket/
 * <p>
 * Time complexity: O(nlogn)
 * <p>
 * Space complexity: O(n)
 */
public class _1196 {

    private static final int MAX = 5000;

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > MAX) {
                return i;
            }
        }

        return arr.length;
    }
}

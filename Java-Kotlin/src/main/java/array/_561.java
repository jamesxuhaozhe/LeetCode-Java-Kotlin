package array;

import java.util.Arrays;

/**
 * Problem link: https://leetcode-cn.com/problems/array-partition-i/
 * <p>
 * Time complexity: O(nlog(n))
 * <p>
 * Space complexity: O(n)
 */
public class _561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

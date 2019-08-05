package array.array_partition_I_561;

import java.util.Arrays;

/**
 * Problem link: https://leetcode-cn.com/problems/array-partition-i/
 *
 * Time complexity: O(nlog(n))
 *
 * Space complexity: O(n)
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

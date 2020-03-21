package array;

import java.util.Arrays;

/**
 * Problem link: https://leetcode-cn.com/problems/majority-element/
 *
 * Time complexity: O(nlogn)
 *
 * Space complexity:
 */
public class _169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

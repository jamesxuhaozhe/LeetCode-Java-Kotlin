package array;

import java.util.Arrays;

/**
 * Problem link: https://leetcode-cn.com/problems/majority-element/
 * <p>
 * Time complexity: O(nlogn)
 * <p>
 * Space complexity:
 */
public class _169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

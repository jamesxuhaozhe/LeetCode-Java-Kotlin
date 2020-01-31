package array.move_zeros_283;

/**
 * Problem link: https://leetcode-cn.com/problems/move-zeroes/
 *
 * Time and Space complexity: O(n)
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

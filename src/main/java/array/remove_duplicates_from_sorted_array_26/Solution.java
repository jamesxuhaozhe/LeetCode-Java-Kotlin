package array.remove_duplicates_from_sorted_array_26;

/**
 * Problem link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}

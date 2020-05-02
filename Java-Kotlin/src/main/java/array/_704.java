package array;

/**
 * Problem link: https://leetcode-cn.com/problems/binary-search/
 * <p>
 * Time complexity: O(logn)
 * <p>
 * Space complexity: O(1)
 */
public class _704 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
        }

        return -1;
    }
}

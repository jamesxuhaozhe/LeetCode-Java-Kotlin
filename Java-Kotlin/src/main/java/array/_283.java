package array;

/**
 * Problem link: https://leetcode-cn.com/problems/move-zeroes/
 *
 * Time and Space complexity: O(n)
 */
public class _283 {

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

    /**
     * this solution is the most optimal since it minimizes the number of operations
     * the idea is to swap the non-zero element to the first zero number position
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        for (int i = 0, j = 0; i < nums.length && j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}

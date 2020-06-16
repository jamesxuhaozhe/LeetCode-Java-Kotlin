package array;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/submissions/
 */
public class _1480 {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }
}

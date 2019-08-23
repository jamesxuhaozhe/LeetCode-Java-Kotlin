package array.maximum_subarray_53;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(0, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, -2, -3, -4, -5, -6, -7, -8};
        System.out.println(new SolutionKt().maxSubArray(nums));
    }
}

package array;

public class _53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(0, sum);
        }

        return max;
    }

    /**
     *遍历到每个num时，有两种情况
     *
     * num值比sum + num大
     * 此时令sum = num
     * 终结了上一段子数组的求和
     * sum + num比较大
     * 那么num加入该子数组，继续往下求和
     * 在整个过程中，比较并刷新最大子数组和res
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for(int num : nums) {
            sum = Math.max(sum + num, num);
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, -2, -3, -4, -5, -6, -7, -8};
        System.out.println(new _53kt().maxSubArray(nums));
    }
}

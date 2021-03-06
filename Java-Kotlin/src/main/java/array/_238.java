package array;

/**
 * Problem link: https://leetcode-cn.com/problems/product-of-array-except-self/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1) expect the result array
 * <p>
 * just take [1, 2, 3, 4] as one example
 */
public class _238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}

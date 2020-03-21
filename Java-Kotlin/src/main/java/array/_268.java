package array;

/**
 * Problem link: https://leetcode-cn.com/problems/missing-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class _268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

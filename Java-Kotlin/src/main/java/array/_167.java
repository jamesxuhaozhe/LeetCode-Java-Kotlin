package array;

/**
 * Problem link: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class _167 {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int last = numbers.length - 1;
        while (start < last) {
            int sum = numbers[start] + numbers[last];
            if (sum == target) {
                return new int[] {start + 1, last + 1};
            }
            if (sum < target) {
                start++;
            } else {
                last--;
            }
        }

        return null;
    }
}

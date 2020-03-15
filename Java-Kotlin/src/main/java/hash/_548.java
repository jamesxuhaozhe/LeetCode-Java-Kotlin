package hash;

import java.util.HashSet;
import java.util.Set;

public class _548 {

    /**
     * Very easy to understand this solution: https://leetcode-cn.com/problems/split-array-with-equal-sum/solution/jiang-shu-zu-fen-ge-cheng-he-xiang-deng-de-zi-shu-/
     * @param nums
     * @return
     */
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }

        // accumulated sum
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int n = nums.length;
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }

            for (int k = j + 2; k < n - 1; k++) {
                if ((sum[k - 1] - sum[j] == sum[n - 1] - sum[k]) && set.contains(sum[n - 1] - sum[k])) {
                    return true;
                }
            }
        }

        return false;
    }
}

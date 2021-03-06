package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem link: https://leetcode.com/problems/two-sum/
 * <p>
 * SolutionDFS idea: Maintain a map value -> index
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class _1 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && (map.get(complement) != i)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution ");
    }
}

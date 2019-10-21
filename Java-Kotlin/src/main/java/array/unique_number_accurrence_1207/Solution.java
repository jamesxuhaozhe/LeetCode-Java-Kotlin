package array.unique_number_accurrence_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Problem link: https://leetcode-cn.com/problems/unique-number-of-occurrences/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("no solution");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                count++;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }

        int numSize = map.keySet().size();
        int valueSize = new HashSet<>(map.values()).size();
        return numSize == valueSize;
    }
    public static void main(String[] args) {
        new Solution().uniqueOccurrences(new int[]{1,2});
    }
}

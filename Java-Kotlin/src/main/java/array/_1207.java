package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Problem link: https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class _1207 {

    public static void main(String[] args) {
        new _1207().uniqueOccurrences(new int[]{1, 2});
    }

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
}

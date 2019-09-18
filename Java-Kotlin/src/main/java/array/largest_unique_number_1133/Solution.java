package array.largest_unique_number_1133;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(entry.getKey(), max);
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}

package string._387;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem link: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class Solution {

    public int firstUniqChar(String s) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.get(ch).frequency++;
            } else {
                map.put(ch, new Pair(1, i));
            }
        }

        int minPos = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            Pair value = entry.getValue();
            if (value.frequency == 1) {
                minPos = Math.min(minPos, value.position);
            }
        }

        if (minPos == Integer.MAX_VALUE) {
            return -1;
        }

        return minPos;
    }

    private static class Pair {
        int frequency;
        int position;

        Pair(int frequency, int position) {
            this.frequency = frequency;
            this.position = position;
        }
    }
}

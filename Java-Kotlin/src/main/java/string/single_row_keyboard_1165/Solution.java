package string.single_row_keyboard_1165;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem link: https://leetcode-cn.com/problems/single-row-keyboard/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 *
 * TODO: need to improve this algo, this one is too crappy
 */
public class Solution {

    public int calculateTime(String keyboard, String word) {
        char[] kbd = keyboard.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < kbd.length; i++) {
            map.put((int) kbd[i], i);
        }

        String converted = "" + kbd[0] + word;
        int sum = 0;
        for (int j = 1; j < converted.length(); j++) {
            int previous = j - 1;
            int indexPrevious = map.get((int) converted.charAt(previous));
            int current = map.get((int) converted.charAt(j));
            sum += Math.abs(current - indexPrevious);
        }

        return sum;
    }
}

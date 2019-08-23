package string.jewels_and_stones_771;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem link: https://leetcode.com/problems/jewels-and-stones/
 * <p>
 * SolutionDFS idea: naive idea
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class Solution {

    public int numJewelsInStones(String J, String S) {
        Set<Integer> typeSets = new HashSet<>();
        char[] types = J.toCharArray();
        for (int i = 0; i < types.length; i++) {
            typeSets.add((int) types[i]);
        }
        int result = 0;
        char[] stones = S.toCharArray();
        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];
            if (typeSets.contains(currentStone)) {
                result++;
            }
        }

        return result;
    }
}

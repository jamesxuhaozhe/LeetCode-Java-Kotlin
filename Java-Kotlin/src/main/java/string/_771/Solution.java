package string._771;

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
        for (char type : types) {
            typeSets.add((int) type);
        }
        int result = 0;
        char[] stones = S.toCharArray();
        for (int currentStone : stones) {
            if (typeSets.contains(currentStone)) {
                result++;
            }
        }

        return result;
    }
}

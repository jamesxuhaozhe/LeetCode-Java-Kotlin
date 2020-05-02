package hash._961;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem link: https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class Solution {

    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}

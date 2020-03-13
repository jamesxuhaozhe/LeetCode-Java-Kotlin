package array._977;

import java.util.Arrays;

/**
 * Problem link: https://leetcode.com/problems/squares-of-a-sorted-array/
 * <p>
 * SolutionDFS idea: naive idea
 * <p>
 * Time complexity: O(nlog(n))
 * <p>
 * Space complexity: O(n)
 */
public class Solution {

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }
}

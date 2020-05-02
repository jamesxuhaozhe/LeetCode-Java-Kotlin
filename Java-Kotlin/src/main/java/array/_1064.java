package array;

/**
 * Problem link: https://leetcode-cn.com/problems/fixed-point/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class _1064 {

    public int fixedPoint(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                return i;
            }
        }

        return -1;
    }
}

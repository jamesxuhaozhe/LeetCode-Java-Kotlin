package nowcoder;

import java.util.Arrays;

// sol: https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/bu-fei-nao-zi-du-neng-kan-dong-de-jie-xi-69bd/
public class nc106 {

    public long solve(int[] A) {
        // write code here
        if (A == null || A.length < 3) {
            return -1;
        }
        Arrays.sort(A);
        int length = A.length;
        return Math.max((long) A[length - 1] * A[length - 2] * A[length - 3], (long) A[0] * A[1] * A[length - 1]);
    }
}
